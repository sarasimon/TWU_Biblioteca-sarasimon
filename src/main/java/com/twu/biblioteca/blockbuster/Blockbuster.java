package com.twu.biblioteca.blockbuster;

import com.twu.biblioteca.StoreInterface;

import java.util.ArrayList;
import java.util.List;

public class Blockbuster implements StoreInterface {

    private List<Movie> listOfMovies;

    public String element() {
        return "movie";
    }

    public Blockbuster() {
        listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("Pulp Ficcion", 1995, "Tarantino", 10));
        listOfMovies.add(new Movie("Reservoir Dogs", 1992, "Tarantino", 10));
        listOfMovies.add(new Movie("Django", 2012, "Tarantino", 10));
    }

    public void addMovie(Movie movie) {
        listOfMovies.add(movie);
    }

    public boolean isAvailable(String title) {
        return getMovie(title).isAvailable();
    }

    public List<Movie> getListOfAvailable() {
        List<Movie> availableMovies = new ArrayList<>();

        for (Movie movie : listOfMovies) {
            if (movie.isAvailable()) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    Movie getMovie(String name) {
        for (Movie movie : listOfMovies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return new NullMovie();
    }

    public String checkOut(String title) {
        for (Movie movie : listOfMovies) {
            if (movie.getName().equals(title)) {
                movie.setAsUnavailable();
                return "Thank you! Enjoy the movie.";
            }
        }
        return "That movie is not available. Please try again.";
    }
}
