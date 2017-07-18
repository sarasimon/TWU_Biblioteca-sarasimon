package com.twu.biblioteca;

public class Menu {

    MenuOutput output;
    MenuInput input;

    public String options(){
        return "Option 1. Show List Of Books";
    }

    public Menu(MenuInput menuInput, MenuOutput menuOutput) {
        output = menuOutput;
        input = menuInput;
    }

    public void open(){
        printOptions();
        readOption();
    }

    public void printOptions() {
        output.printMenu(options());
    }


    public void readOption() {
        if(input.readOption().equals("1"))
            output.printListOfBooks();
        else
            return;
    }
}
