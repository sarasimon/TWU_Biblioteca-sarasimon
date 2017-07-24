package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.biblioteca.BibliotecaService;

public class ReturnAction implements Action{

    private BibliotecaService bibliotecaService;
    private Input input;

    public ReturnAction(Input input, BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
        this.input = input;
    }

    public boolean go() {
        if (!LoginService.getInstance().userIsLoggedIn()) {
            System.out.println("You are not logged in.");
            return true;
        }

        String title = answerTo("Please, give the title of the book you want to return:");
        System.out.println(bibliotecaService.returnBook(title));
        return true;
    }

    public String description(String number) {
        return "Option " + number + ". Return a book";
    }

    String answerTo(String question){
        System.out.println(question);
        return input.read();
    }
}
