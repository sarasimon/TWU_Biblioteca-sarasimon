package com.twu.biblioteca;

public class Movie {

    private String name;
    private Integer year;
    private String director;
    private Integer rating;
    private Boolean isAvailable;

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Integer getRating() {
        return rating;
    }

    public void checkOutMovie(){
        isAvailable = false;
    }

    public Movie(String name, Integer year, String director, Integer rating){
        this.name = name;
        this.director = director;
        this.rating = rating;
        this.year = year;
        this.isAvailable = true;
    }

}
