package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.Input;
import com.twu.biblioteca.Menu;

public class BibliotecaApp {

    public void start(Menu menu){
        menu.open();
    }

    public static void main(String[] args) {
        Menu menu = new Menu(new Input());
        menu.open();
    }
}
