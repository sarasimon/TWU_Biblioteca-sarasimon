package com.twu.biblioteca.action;

public class InvalidAction extends Action {

    @Override
    public boolean go() {
        System.out.println("Select a valid option!");
        return true;
    }
}
