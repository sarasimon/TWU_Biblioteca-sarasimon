package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {

    private List<Book> books;

    public Biblioteca() {
        books = new ArrayList<Book>();
        books.add(new Book("Bible", "Jesus", 0));
        books.add(new Book("Refactoring", "M. Fowler", 1990));
    }

    public List<Book> getListOfBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean checkOut(String title) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getTitle().equals(title)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean titleExists(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
