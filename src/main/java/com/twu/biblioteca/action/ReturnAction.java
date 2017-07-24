package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.Biblioteca;

public class ReturnAction extends ActionWithInputAndStore {

    public ReturnAction(Input input, StoreInterface biblioteca) {
        super(biblioteca, input);
    }

    public boolean go() {
        if (!LoginService.getInstance().userIsLoggedIn()) {
            System.out.println("You are not logged in.");
            return true;
        }

        String title = answerTo("Please, give the title of the book you want to return:");
        Biblioteca biblioteca = (Biblioteca) store;
        System.out.println(biblioteca.returnBook(title));
        return true;
    }

    public String description(String number) {
        return "Option " + number + ". Return a book";
    }
}
