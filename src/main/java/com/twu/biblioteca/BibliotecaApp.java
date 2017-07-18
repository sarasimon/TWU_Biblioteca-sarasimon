package com.twu.biblioteca;

public class BibliotecaApp {

    private Menu menu;

    public BibliotecaApp(Menu menu){
        this.menu = menu;
    }

    public void start(){
        System.out.println("***************** Welcome to \"la Biblioteca\" *****************");
        menu.open();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Menu(new MenuInput(), new MenuOutput()));
        bibliotecaApp.start();
    }
}
