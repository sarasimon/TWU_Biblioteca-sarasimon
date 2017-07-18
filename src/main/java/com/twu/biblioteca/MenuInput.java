package com.twu.biblioteca;
import java.util.Scanner;

public class MenuInput {

    Scanner scanner = new Scanner(System.in);

    public String readOption(){
        String opt = scanner.next();
        return opt;
    }
}
