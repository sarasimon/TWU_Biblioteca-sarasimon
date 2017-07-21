package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;

public class InvalidAction extends Action {

    @Override
    public boolean go() {
        System.out.println("Select a valid option!");
        return true;
    }
}
