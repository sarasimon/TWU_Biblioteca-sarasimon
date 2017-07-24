package com.twu.biblioteca.biblioteca;
import com.twu.biblioteca.Rentable;

public class Book implements Rentable{

    private String author;
    private Integer yearPublished;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    private String title;

    public Book(String title, String author, Integer yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

}
