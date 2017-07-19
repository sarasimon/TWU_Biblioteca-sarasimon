package com.twu.biblioteca;

public class MenuOutput {

    public void printWelcome(){
        System.out.println("***************** Welcome to \"la Biblioteca\" *****************");
    }

    public void printMenu(String options){
        System.out.println("This is the menu: (Press number and Intro to select an option)");
        System.out.println(options);
    }
}
