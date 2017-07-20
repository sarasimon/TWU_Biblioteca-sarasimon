package com.twu.biblioteca.action;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;

public class ShowListOfBooksAction extends Action {

    private final String DISPLAYFORMAT = "%-15s %-15s %-10s\n";

    public ShowListOfBooksAction(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean go() {
        String outputInColumns = String.format(DISPLAYFORMAT, "Title", "Author", "Year Published");
        for (Book iBook : biblioteca.getListOfBooks()) {
            outputInColumns += String.format(DISPLAYFORMAT, iBook.getTitle(), iBook.getAuthor(), iBook.getYearPublished());
        }
        System.out.println(outputInColumns);
        return true;
    }
}
