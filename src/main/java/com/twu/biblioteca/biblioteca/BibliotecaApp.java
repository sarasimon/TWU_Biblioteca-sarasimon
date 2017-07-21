package com.twu.biblioteca;

public class BibliotecaApp {

    public void start(Menu menu){
        menu.open();
    }

    public static void main(String[] args) {
        Menu menu = new Menu(new Input(), new MenuOutput());
        menu.open();
    }
}
