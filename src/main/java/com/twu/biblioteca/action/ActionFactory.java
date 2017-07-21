package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.Input;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.blockbuster.Blockbuster;

public class ActionFactory {

    public static Action getAction(String option, Input input, Biblioteca biblioteca, Blockbuster blockbuster){
        if (option.equals("1")) {
            return new ShowListOfBooksAction(biblioteca);
        } else if (option.equals("2")) {
            return new CheckOutAction(input, biblioteca);
        } else if (option.equals("3")) {
            return new ReturnAction(input, biblioteca);
        } else if (option.equals("4")) {
            return new ShowListOfMoviesAction(blockbuster);
        } else if (option.equals("5")) {
            return new CheckOutAction(input, blockbuster);
        } else if (option.equals("6")) {
            return new LogInAction(input);
        } else if (option.equals("q")) {
            return new QuitAction();
        } else {
            return new InvalidAction();
        }
    }
}
