package com.twu.biblioteca.action;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Input;

public class CheckOutAction extends Action {

    private Input input;

    public CheckOutAction(Input input, Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.input = input;
    }

    public boolean go() {
        System.out.println("Please, give the title of the book you want to check out:");
        String title = input.read();
        if (isAbleToCheckOut(title)) {
            checkOutBook(title);
            return true;
        } else {
            System.out.println("That book is not available.");
            return false;
        }
    }

    private void checkOutBook(String title) {
        if (biblioteca.checkOut(title)) {
            System.out.println("Thank you! Enjoy the book");
        }
    }

    private boolean isAbleToCheckOut(String title) {
        return biblioteca.bookIsIn(title);
    }
}
