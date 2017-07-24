package com.twu.biblioteca.action;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.Input;

public class CheckOutAction extends ActionWithInputAndStore {

    public CheckOutAction(StoreInterface store, Input input) {
        super(store, input);
    }

    public boolean go() {
        if (!LoginService.getInstance().userIsLoggedIn()) {
            System.out.println("You are not logged in.");
            return true;
        }

        String title = answerTo("Please, give the " + store.element() + " you want to check out:");
        System.out.println(store.checkOut(title));
        return true;
    }

    public String description(String number) {
        return "Option " + number + ". Check out a " + store.element();
    }
}
