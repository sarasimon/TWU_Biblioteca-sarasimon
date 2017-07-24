package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.StoreInterface;

import java.util.*;
import java.util.concurrent.Callable;

public class Biblioteca{

    public Set<Map.Entry<Book, User>> getLibrary() {
        return library.entrySet();
    }

    private Map<Book, User> library;

    public Biblioteca() {
        library = new HashMap<>();
        addBook(new Book("Bible", "Jesus", 0));
        addBook(new Book("Refactoring", "M. Fowler", 1990));
    }

    void addBook(Book book) {
        library.put(book, new NoUser());
    }


    public boolean bookIsInList(String title, Book book) {
        return book.getTitle().equals(title);
    }

    public boolean bookIsNotCheckedOut(String title, Book book, User user) {
        return book.getTitle().equals(title) && (user instanceof NoUser);
    }
}
