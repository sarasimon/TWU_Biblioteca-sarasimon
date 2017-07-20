package com.twu.biblioteca.action;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Input;

public class ActionFactory {

    public static Action getAction(String option, Input input, Biblioteca biblioteca){
        if (option.equals("1")) {
            return new ShowListOfBooksAction(biblioteca);
        } else if (option.equals("2")) {
            return new CheckOutAction(input, biblioteca);
        } else if (option.equals("3")) {
            return new ReturnAction(input, biblioteca);
        } else if (option.equals("q")) {
            return new QuitAction();
        } else {
            return new InvalidAction();
        }
    }
}
