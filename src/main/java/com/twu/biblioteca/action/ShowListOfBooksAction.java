package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.Book;

public class ShowListOfBooksAction extends Action {

    public ShowListOfBooksAction(StoreInterface biblioteca){
        super(biblioteca);
    }

    public boolean go() {
        String outputInColumns = titlesInColumns("Title", "Author", "Year Published");
        for (Rentable iBook : store.getListOfAvailable()) {
            outputInColumns += infoInColumns((Book) iBook);
        }
        System.out.println(outputInColumns);
        return true;
    }

    private final String DISPLAYFORMAT = "%-15s %-15s %-10s\n";

    private String titlesInColumns(String title, String author, String year) {
        return String.format(DISPLAYFORMAT, title, author, year);
    }

    private String infoInColumns(Book iBook) {
        return String.format(DISPLAYFORMAT, iBook.getTitle(), iBook.getAuthor(), iBook.getYearPublished());
    }
}
