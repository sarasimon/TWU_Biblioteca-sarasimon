package com.twu.biblioteca.blockbuster;

import com.twu.biblioteca.Rentable;

public class Movie implements Rentable{

    private String name;
    private Integer year;
    private String director;
    private Integer rating;
    private Boolean available;

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Boolean isAvailable(){ return available; }

    public Integer getRating() {
        if (rating < 1) {
            rating = 1;
        } else if (rating > 10) {
            rating = 10;
        }
        return rating;
    }

    void setAsUnavailable() {
        available = false;
    }

    public Movie(String name, Integer year, String director, Integer rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
        this.year = year;
        this.available = true;
    }

}
