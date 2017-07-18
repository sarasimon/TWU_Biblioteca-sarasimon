package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Book> books;
    public static final String BOOKDISPLAYFORMAT = "%-30.30s  %-30.30s%n";

    public Biblioteca(List<Book> books){
        this.books = books;
    }

    public void printListOfBooks() {
        String outputInColumns = String.format(Biblioteca.BOOKDISPLAYFORMAT, "Author", "Year Published");
        for (Book iBook: books) {
            outputInColumns += String.format(Biblioteca.BOOKDISPLAYFORMAT, iBook.getAuthor(), iBook.getYearPublished());
        }

        System.out.println(outputInColumns);
    }
}
