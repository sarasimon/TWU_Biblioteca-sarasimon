package com.twu.biblioteca;

import com.twu.biblioteca.action.*;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.blockbuster.Blockbuster;

import java.util.ArrayList;
import java.util.List;

public class Options {

    private Biblioteca biblioteca;
    private Blockbuster blockbuster;
    private Input input;
    private List<String> listOfOptions;

    public enum Strings {
        A("Option 1. Show list of books"),
        B("Option 2. Check out a book"),
        C("Option 3. Return a book"),
        D("Option 4. Show list of movies"),
        E("Option 5. Check out a movie"),
        F("Option 6. Quit de program (press \"q\")");

        private final String text;

        private Strings(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public Options(Biblioteca biblioteca, Blockbuster blockbuster, Input input) {
        this.biblioteca = biblioteca;
        this.blockbuster = blockbuster;
        this.input = input;

        listOfOptions = new ArrayList<>();

    }

    public void ask() {
        System.out.println("\nThis is the menu: (Press number and Intro to select an option)");
        for (Strings d : Strings.values()) {
            System.out.println(d.toString());
        }
    }

    public Boolean returnOptions(String opt) {
        Action action = ActionFactory.getAction(opt, input, biblioteca, blockbuster);
        return action.go();
    }

}
