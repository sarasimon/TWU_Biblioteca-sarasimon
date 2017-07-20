package com.twu.biblioteca;

import com.twu.biblioteca.action.*;

public class Options {

    private Biblioteca biblioteca;
    private Input input;

    public Options(Biblioteca biblioteca, Input input) {
        this.biblioteca = biblioteca;
        this.input = input;
    }

    public String ask() {
        return "Option 1. Show List Of Books\nOption 2. Check out a book\nOption 3. Return a book\nOption 4. Quit de program (press \"q\")";
    }

    public Boolean returnOptions(String opt) {
        Action action = ActionFactory.getAction(opt, input, biblioteca);
        return action.go();
    }

}
