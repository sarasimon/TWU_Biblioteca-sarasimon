package com.twu.biblioteca.action;

import com.twu.biblioteca.Input;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.blockbuster.Blockbuster;

public class ActionFactory {

    private Input input;
    private Blockbuster blockbuster;
    private Biblioteca biblioteca;

    private ActionFactory(Input input, Biblioteca biblioteca, Blockbuster blockbuster){
        this.biblioteca = biblioteca;
        this.blockbuster = blockbuster;
        this.input = input;
    }

    public static ActionFactory createActionFactory(Input input, Biblioteca biblioteca, Blockbuster blockbuster){
        return new ActionFactory(input,biblioteca,blockbuster);
    }

    public String stringOfActions(){
        String menuString = "";
        for (int i = 1; i < 7; i++) {
            String number = Integer.toString(i);
            menuString += getAction(number).description(number) + "\n";
        }
        return menuString;
    }

    public Action getAction(String option){
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
        } else if (option.equals("7")) {
            return new QuitAction();
        } else {
            return new InvalidAction();
        }
    }
}
