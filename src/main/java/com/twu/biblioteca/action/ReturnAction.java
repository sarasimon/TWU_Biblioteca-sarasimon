package com.twu.biblioteca.action;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Input;

public class ReturnAction extends Action {

    private Biblioteca biblioteca;
    private Input input;

    public ReturnAction(Input input, Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.input = input;
    }

    public boolean go() {
        System.out.println("Please, give the title of the book you want to return:");
        String title = input.read();
        if (biblioteca.bookWasCheckedOut(title)) {
            biblioteca.returnBook(title);
            System.out.println("Thank you for returning the book.");
            return true;
        } else {
//            System.out.println("That book is not available.");
            return false;
        }
    }
}
