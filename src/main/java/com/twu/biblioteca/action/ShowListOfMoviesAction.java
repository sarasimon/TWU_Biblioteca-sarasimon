package com.twu.biblioteca.action;

import com.twu.biblioteca.Rentable;
import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.biblioteca.Book;
import com.twu.biblioteca.blockbuster.Movie;

public class ShowListOfMoviesAction extends ShowListOfRentable {

    private String DISPLAYFORMAT = "%-15s %-15s %-10s %-15s\n";

    public ShowListOfMoviesAction(StoreInterface biblioteca) {
        super(biblioteca);
    }

    String headersInColumns() {
        return String.format(DISPLAYFORMAT, "Name", "Director", "Year", "Rating");
    }

    String detailsInColumns(Rentable iMovie) {
        return String.format(DISPLAYFORMAT, ((Movie) iMovie).getName(), ((Movie) iMovie).getDirector(), ((Movie) iMovie).getYear(), ((Movie) iMovie).getRating());
    }
}
