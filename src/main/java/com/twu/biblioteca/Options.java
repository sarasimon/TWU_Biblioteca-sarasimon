package com.twu.biblioteca;

import com.twu.biblioteca.action.*;

public class Options {

    private Biblioteca biblioteca;
    private Input input;

    public Options() {
        this.biblioteca = new Biblioteca();
    }

    public Options(Biblioteca biblioteca, Input input) {
        this.biblioteca = biblioteca;
        this.input = input;
    }

    public String ask() {
        return "Option 1. Show List Of Books (Press 1)\nOption 2. Check out a book (Insert title of the book)\nOption 3. Quit de program (press \"q\")";
    }

    public Boolean returnOptions(String opt) {
        Action action;
        if (opt.equals("1")) {
            action = new ShowListOfBooksAction(biblioteca);
            return action.go();
        } else if (opt.equals("2")) {
            action = new CheckOutAction(input, biblioteca);
            return action.go();
        } else if (opt.equals("3")) {
            action = new ReturnAction(input, biblioteca);
            return action.go();
        } else if (opt.equals("q")) {
            action = new QuitAction();
            return action.go();
        } else {
            action = new InvalidAction();
            return action.go();
        }
    }

}
