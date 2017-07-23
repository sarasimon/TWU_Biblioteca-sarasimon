package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.Input;

public class CheckOutAction extends ActionWithInputAndStore {

    public CheckOutAction(Input input, StoreInterface store) {
        super(store, input);
    }

    public boolean go() {
        String title = answerTheQuestion("Please, give the " + store.element() + " you want to check out:");
        if (isAbleToCheckOut(title)) {
            checkOutBook(title);
        } else {
            System.out.println("That " + store.element() + " is not available. Please try again.\n");
        }
        return true;
    }

    public String description(String number) {
        return "Option " + number + ". Check out a " + store.element();
    }

    private void checkOutBook(String title) {
        if (store.checkOut(title)) {
            System.out.println("Thank you! Enjoy the " + store.element());
        }
    }

    private boolean isAbleToCheckOut(String title) {
        return store.isAvailable(title);
    }
}
