package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.Input;

public class ReturnAction extends ActionWithInputAndStore {

    public ReturnAction(Input input, StoreInterface biblioteca) {
        super(biblioteca, input);
    }

    public boolean go() {
        System.out.println("Please, give the title of the book you want to return:");
        String title = input.read();
        if (((Biblioteca) store).bookWasCheckedOut(title)) {
            ((Biblioteca) store).returnBook(title);
            System.out.println("Thank you for returning the book.");
            return true;
        } else {
            System.out.println("That is not a valid book to return, try again");
            return false;
        }
    }
}
