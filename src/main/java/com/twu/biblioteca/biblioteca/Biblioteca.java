package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.StoreInterface;

import java.util.*;

public class Biblioteca implements StoreInterface {

    private Map<Book, User> library;

    public String element() {
        return "book";
    }

    LoginService loginService;

    public Biblioteca(LoginService loginService) {
        library = new HashMap<>();
        this.loginService = loginService;
        addBook(new Book("Bible", "Jesus", 0));
        addBook(new Book("Refactoring", "M. Fowler", 1990));
    }

    void addBook(Book book) {
        library.put(book, new NoUser());
    }

    public String checkOut(String title) {
        for (Map.Entry<Book, User> entry : library.entrySet()) {
            if (bookIsInList(title,entry)) {
                entry.setValue(loginService.getUser());
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available. Please try again.";
    }

    private boolean bookIsInList(String title, Map.Entry<Book, User> entry){
        return entry.getKey().getTitle().equals(title);
    }

    public String returnBook(String title) {
        return loopWithCondition(title, new NoUser(), "Thank you for returning the book.",
                "It wasn't possible to return the book.");
    }

    private String loopWithCondition(String title, User user, String s1, String s2) {
        for (Map.Entry<Book, User> entry : library.entrySet()) {
            if (bookCanBeReturnedByUser(title, entry)) {
                entry.setValue(user);
                return s1;
            }
        }
        return s2;
    }

    private boolean bookCanBeReturnedByUser(String title, Map.Entry<Book, User> entry) {
        return entry.getKey().getTitle().equals(title)
                && entry.getValue().equals(loginService.getUser());
    }

    public List<Book> getListOfAvailable() {
        List<Book> books = new ArrayList<>();
        for (Map.Entry<Book, User> entry : library.entrySet()) {
            if (entry.getValue() instanceof NoUser) {
                books.add(entry.getKey());
            }
        }
        return books;
    }

    public boolean isAvailable(String title) {
        for (Map.Entry<Book, User> entry : library.entrySet()) {
            if (bookIsNotCheckedOut(title, entry)) {
                return true;
            }
        }
        return false;
    }

    private boolean bookIsNotCheckedOut(String title, Map.Entry<Book, User> entry) {
        return entry.getKey().getTitle().equals(title) && (entry.getValue() instanceof NoUser);
    }
}
