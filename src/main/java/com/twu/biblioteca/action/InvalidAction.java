package com.twu.biblioteca.action;

public class InvalidAction implements Action {

    public boolean go() {
        System.out.println("Select a valid option!");
        return true;
    }

    public String description(String s) {
        return "";
    }
}
