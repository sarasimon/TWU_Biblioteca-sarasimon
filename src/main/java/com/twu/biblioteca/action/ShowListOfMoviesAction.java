package com.twu.biblioteca.action;

import com.twu.biblioteca.Rentable;
import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.blockbuster.Movie;

public class ShowListOfMoviesAction extends Action {

    private final String DISPLAYFORMAT = "%-15s %-15s %-15s %-10s\n";

    public ShowListOfMoviesAction(StoreInterface biblioteca) {
        super(biblioteca);
    }

    @Override
    public boolean go() {
        String outputInColumns = String.format(DISPLAYFORMAT, "Name", "Director", "Year", "Rating");
        for (Rentable iMovie : store.getListOfAvailable()) {
            outputInColumns += String.format(DISPLAYFORMAT, ((Movie)iMovie).getName(), ((Movie)iMovie).getDirector(), ((Movie)iMovie).getYear(), ((Movie)iMovie).getRating());
        }
        System.out.println(outputInColumns);
        return true;
    }
}
