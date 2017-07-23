package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.Biblioteca;

public class ReturnAction extends ActionWithInputAndStore {

    public ReturnAction(Input input, StoreInterface biblioteca) {
        super(biblioteca, input);
    }

    public boolean go() {
        String title = answerTheQuestion("Please, give the title of the book you want to return:");
        Biblioteca biblioteca = (Biblioteca) store;

        if (biblioteca.bookWasCheckedOut(title)) {
            biblioteca.returnBook(title);
            System.out.println("Thank you for returning the book.");
            return true;
        } else {
            System.out.println("That is not a valid book to return, try again");
            return false;
        }
    }

    public String description(String number) {
        return "Option " + number + ". Return a book";
    }
}
