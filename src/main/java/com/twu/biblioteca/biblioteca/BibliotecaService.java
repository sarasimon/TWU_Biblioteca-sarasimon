package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.StoreInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BibliotecaService implements StoreInterface{

    private Biblioteca biblioteca;
    private LoginService loginService;

    public String element() {
        return "book";
    }

    public BibliotecaService(LoginService loginService, Biblioteca biblioteca) {
        this.loginService = loginService;
        this.biblioteca = biblioteca;
    }

    public String checkOut(String title) {
        for (Map.Entry<Book, User> entry : biblioteca.getLibrary()) {
            if (biblioteca.bookIsNotCheckedOut(title, entry.getKey(), entry.getValue())) {
                entry.setValue(loginService.getUser());
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available. Please try again.";
    }

    public String returnBook(String title) {
        for (Map.Entry<Book, User> entry : biblioteca.getLibrary()) {
            if (biblioteca.bookIsInList(title, entry.getKey()) && entry.getValue().equals(loginService.getUser())) {
                entry.setValue(new NoUser());
                return "Thank you for returning the book.";
            }
        }
        return "It wasn't possible to return the book.";
    }

    public List<Book> getListOfAvailable() {
        List<Book> books = new ArrayList<>();
        for (Map.Entry<Book, User> entry : biblioteca.getLibrary()) {
            if (entry.getValue() instanceof NoUser) {
                books.add(entry.getKey());
            }
        }
        return books;
    }

    public boolean isAvailable(String title) {
        for (Map.Entry<Book, User> entry : biblioteca.getLibrary()) {
            if (biblioteca.bookIsNotCheckedOut(title, entry.getKey(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
