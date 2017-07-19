package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Book> books;

    public Biblioteca(){
        books = new ArrayList<Book>();
        books.add(new Book("Bible","Jesus",0));
        books.add(new Book("Refactoring", "M. Fowler", 1990));
    }

    public List<Book> getListOfBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void checkOut(Book book) {
        books.remove(book);
    }
}
