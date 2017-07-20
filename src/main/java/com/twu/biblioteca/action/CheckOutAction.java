package com.twu.biblioteca;

public class CheckOutAction extends Action{

    private Input input;

    public CheckOutAction(Input input, Biblioteca biblioteca) {
        super(biblioteca);
        this.input = input;
    }

    public void go() {
        System.out.println("Please, give the title of the book you want to check out:");
        String title = input.read();
        if (isAbleToCheckOut(title)) {
            checkOutBook(title);
        } else {
            System.out.println("That book is not available.");
        }
    }

    private void checkOutBook(String title) {
        if (biblioteca.checkOut(title)) {
            System.out.println("Thank you! Enjoy the book");
        }
    }

    private boolean isAbleToCheckOut(String title) {
        return biblioteca.titleExists(title);
    }
}
