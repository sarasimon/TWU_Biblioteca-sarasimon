package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.Book;

public class ShowListOfBooksAction extends ShowListOfRentable {

    private String DISPLAYFORMAT = "%-15s %-15s %-10s\n";

    public ShowListOfBooksAction(StoreInterface biblioteca) {
        super(biblioteca);
    }

    String headersInColumns() {
        return String.format(DISPLAYFORMAT, "Title", "Author", "Year Published");
    }

    String detailsInColumns(Rentable iBook) {
        return String.format(DISPLAYFORMAT, ((Book)iBook).getTitle(), ((Book)iBook).getAuthor(), ((Book)iBook).getYearPublished());
    }
}
