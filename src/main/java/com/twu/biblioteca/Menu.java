package com.twu.biblioteca;

public class Menu {

    MenuOutput output;
    MenuInput input;
    Options options;

    public Menu(MenuInput menuInput, MenuOutput menuOutput, Options options) {
        output = menuOutput;
        input = menuInput;
        this.options = options;
    }

    public void open() {
        output.printWelcome();
        output.printMenu(options.ask());
        String opt = input.read();

        while (options.returnOptions(opt)){
            output.printMenu(options.ask());
            opt = input.read();
        }
    }


}
