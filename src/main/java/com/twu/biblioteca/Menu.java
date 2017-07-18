package com.twu.biblioteca;

public class Menu {

    MenuOutput output;
    MenuInput input;

    public String options() {
        return "Option 1. Show List Of Books";
    }

    public Menu(MenuInput menuInput, MenuOutput menuOutput) {
        output = menuOutput;
        input = menuInput;
    }

    public void open() {
        output.printMenu(options());
        String opt = input.read();

        if (opt.equals("1")) {
            output.printListOfBooks();
        } else if (opt.equals("q")) {
            return;
        } else{
            output.printInvalidOption();
        }

        open();
    }
}
