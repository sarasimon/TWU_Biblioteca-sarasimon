package com.twu.biblioteca;

import com.twu.biblioteca.action.*;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.biblioteca.BibliotecaService;
import com.twu.biblioteca.blockbuster.Blockbuster;

import java.util.ArrayList;
import java.util.List;

public class Options {

    ActionFactory actionFactory;

    public Options(BibliotecaService bibliotecaService, Blockbuster blockbuster, Input input) {
        actionFactory = ActionFactory.createActionFactory(input,bibliotecaService,blockbuster);
    }

    public void ask() {
        System.out.println("\nThis is the menu: (Press number and Intro to select an option)");
        System.out.println(actionFactory.stringOfActions());
    }

    public Boolean returnOptions(String opt) {
        Action action = actionFactory.getAction(opt);
        return action.go();
    }

}
