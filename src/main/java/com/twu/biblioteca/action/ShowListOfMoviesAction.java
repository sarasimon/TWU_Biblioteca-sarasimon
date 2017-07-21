package com.twu.biblioteca.action;

import com.twu.biblioteca.Rentable;
import com.twu.biblioteca.StoreInterface;
import com.twu.biblioteca.biblioteca.Book;
import com.twu.biblioteca.blockbuster.Movie;

public class ShowListOfMoviesAction extends Action {

    public ShowListOfMoviesAction(StoreInterface biblioteca) {
        super(biblioteca);
    }

    public boolean go() {
        String outputInColumns = titlesInColumns("Name", "Director", "Year", "Rating");
        for (Rentable iMovie : store.getListOfAvailable()) {
            outputInColumns += infoInColumns((Movie) iMovie);
        }
        System.out.println(outputInColumns);
        return true;
    }

    private final String DISPLAYFORMAT = "%-15s %-15s %-15s %-10s\n";

    private String titlesInColumns(String name, String director, String year, String rating) {
        return String.format(DISPLAYFORMAT, name, director, year, rating);
    }

    private String infoInColumns(Movie iMovie){
        return String.format(DISPLAYFORMAT, iMovie.getName(), iMovie.getDirector(), iMovie.getYear(), iMovie.getRating());
    }
}
