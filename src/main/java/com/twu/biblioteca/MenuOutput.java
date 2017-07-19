package com.twu.biblioteca;

public class MenuOutput {

    Biblioteca biblioteca = new Biblioteca();

    public static final String BOOKDISPLAYFORMAT = "%-15s %-15s %-10s\n";

    public void printMenu(String options){
        System.out.println("This is the menu: (Press number and Intro to select an option)");
        System.out.println(options);
    }

    public void printListOfBooks() {
        String outputInColumns = String.format(BOOKDISPLAYFORMAT, "Title", "Author", "Year Published");
        for (Book iBook: biblioteca.getListOfBooks()) {
            outputInColumns += String.format(BOOKDISPLAYFORMAT, iBook.getTitle(), iBook.getAuthor(), iBook.getYearPublished());
        }

        System.out.println(outputInColumns);
    }

    public void printInvalidOption(){
        System.out.println("Select a valid option!");
    }
}
