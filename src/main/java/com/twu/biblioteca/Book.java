package com.twu.biblioteca;


public class Book {

    private String author;
    private Integer yearPublished;

    public String getTitle() {
        return title;
    }

    private String title;

    public Book(String title, String author, Integer yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }
}
