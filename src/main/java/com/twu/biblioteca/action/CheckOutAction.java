package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.Input;

public class CheckOutAction extends ActionWithInputAndStore {

    public CheckOutAction(Input input, StoreInterface store) {
        super(store, input);
    }

    public boolean go() {
        System.out.println("Please, give the " + store.element() + " you want to check out:");
        String title = input.read();
        if (isAbleToCheckOut(title)) {
            checkOutBook(title);
            return true;
        } else {
            System.out.println("That " + store.element() + " is not available. Please try again.\n");
            return true;
        }
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
