package com.twu.biblioteca;


public class Book {

    private String author;
    private Integer yearPublished;

    public Book(String author, Integer yearPublished){
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
