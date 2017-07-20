package com.twu.biblioteca;
import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public String read(){
        String opt = scanner.next();
        return opt;
    }
}
