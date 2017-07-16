package com.twu.biblioteca;

public class BibliotecaApp {

    private Biblioteca biblioteca;

    public final String WelcomeMessage = "***************** Welcome to \"la Biblioteca\" *****************";

    public BibliotecaApp(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        printMessage();
        printListOfBooks();
    }

    public void printMessage() {
        System.out.println(WelcomeMessage);
    }

    public void printListOfBooks() {
        System.out.println(biblioteca.getBooks());
    }
}
