package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.Rentable;
import com.twu.biblioteca.biblioteca.Book;

public class ShowListOfBooksAction extends Action {

    private final String DISPLAYFORMAT = "%-15s %-15s %-10s\n";

    public ShowListOfBooksAction(StoreInterface biblioteca){
        super(biblioteca);
    }

    public boolean go() {
        String outputInColumns = String.format(DISPLAYFORMAT, "Title", "Author", "Year Published");
        for (Rentable iBook : store.getListOfAvailable()) {
            outputInColumns += String.format(DISPLAYFORMAT, ((Book)iBook).getTitle(), ((Book)iBook).getAuthor(), ((Book)iBook).getYearPublished());
        }
        System.out.println(outputInColumns);
        return true;
    }
}
