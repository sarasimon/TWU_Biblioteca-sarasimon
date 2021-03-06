package com.twu.biblioteca.action;

import com.twu.biblioteca.Input;
import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.biblioteca.BibliotecaService;
import com.twu.biblioteca.blockbuster.Blockbuster;

public class ActionFactory {

    private Input input;
    private Blockbuster blockbuster;
    private BibliotecaService bibliotecaService;

    private ActionFactory(Input input, BibliotecaService bibliotecaService, Blockbuster blockbuster){
        this.bibliotecaService = bibliotecaService;
        this.blockbuster = blockbuster;
        this.input = input;
    }

    public static ActionFactory createActionFactory(Input input, BibliotecaService bibliotecaService, Blockbuster blockbuster){
        return new ActionFactory(input,bibliotecaService,blockbuster);
    }

    public String stringOfActions(){
        String menuString = "";
        for (int i = 1; i < 8; i++) {
            String number = Integer.toString(i);
            menuString += getAction(number).description(number) + "\n";
        }
        return menuString;
    }

    public Action getAction(String option){
        if (option.equals("1")) {
            return new ShowListOfBooksAction(bibliotecaService);
        } else if (option.equals("2")) {
            return new CheckOutAction(bibliotecaService, input);
        } else if (option.equals("3")) {
            return new ReturnAction(input, bibliotecaService);
        } else if (option.equals("4")) {
            return new ShowListOfMoviesAction(blockbuster);
        } else if (option.equals("5")) {
            return new CheckOutAction(blockbuster, input);
        } else if (option.equals("6")) {
            return new LogInAction(input);
        } else if (option.equals("7")) {
            return new QuitAction();
        } else {
            return new InvalidAction();
        }
    }
}
