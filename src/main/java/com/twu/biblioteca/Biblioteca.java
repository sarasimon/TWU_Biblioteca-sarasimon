package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    public List<String> getBooks() {
        return books;
    }

    private List<String> books;

    public Biblioteca(){
        books = new ArrayList<String>();
        books.add("A");
        books.add("B");
    }
}
