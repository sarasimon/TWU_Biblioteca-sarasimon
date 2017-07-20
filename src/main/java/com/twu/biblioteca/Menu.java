package com.twu.biblioteca;

public class Menu {

    MenuOutput output;
    Input input;
    Options options;

    public Menu(Input input, MenuOutput menuOutput) {
        output = menuOutput;
        this.input = input;
        this.options = new Options(new Biblioteca(), input);
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
