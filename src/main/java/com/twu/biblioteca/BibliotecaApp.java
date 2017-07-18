package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private Biblioteca biblioteca;
    private Welcome welcome;

    public BibliotecaApp(Biblioteca biblioteca, Welcome welcome){
        this.biblioteca = biblioteca;
        this.welcome = welcome;
    }

    public void start(){
        welcome.printMessage();
        biblioteca.printListOfBooks();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Biblioteca(new ArrayList<Book>()), new Welcome());
        bibliotecaApp.start();
    }
}
