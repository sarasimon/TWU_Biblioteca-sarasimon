package com.twu.biblioteca;

public class MenuOutput {

    public void printWelcome(){
        System.out.println("***************** Welcome to \"la Biblioteca\" *****************");
    }

    public void printMenu(String options){
        System.out.println("\nThis is the menu: (Press number and Intro to select an option)");
        System.out.println(options);
    }
}
