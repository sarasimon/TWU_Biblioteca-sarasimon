package com.twu.biblioteca.action;

public class QuitAction implements Action {

    public boolean go() {
        return false;
    }

    public String description(String number) {
        return "Option " + number + ". Quit de program";
    }
}
