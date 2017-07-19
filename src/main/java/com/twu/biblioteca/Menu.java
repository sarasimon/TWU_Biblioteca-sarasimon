package com.twu.biblioteca;

public class Menu {

    MenuOutput output;
    MenuInput input;

    public String options() {
        return "Option 1. Show List Of Books + \n + Option q. Quit de program";
    }

    public Menu(MenuInput menuInput, MenuOutput menuOutput) {
        output = menuOutput;
        input = menuInput;
    }

    public void open(String question) {
        output.printMenu(question);
        String opt = input.read();

        while (returnOptions(opt)){
            output.printMenu(options());
            opt = input.read();
        }
    }

    private Boolean returnOptions(String opt) {
        if (opt.equals("1")) {
            output.printListOfBooks();
        } else if (opt.equals("q")) {
            return false;
        } else {
            output.printInvalidOption();
        }
        return true;
    }
}
