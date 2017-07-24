package com.twu.biblioteca;

import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.biblioteca.BibliotecaService;
import com.twu.biblioteca.blockbuster.Blockbuster;

public class Menu {

    Input input;
    Options options;

    public Menu(Input input) {
        this.input = input;
        this.options = new Options(new BibliotecaService(LoginService.getInstance(), new Biblioteca()), new Blockbuster(), input);
    }

    public void open() {
        System.out.println("***************** Welcome to \"la Biblioteca\" *****************");
        String opt;

        do {
            options.ask();
            opt = input.read();
        } while (options.returnOptions(opt));
    }


}
