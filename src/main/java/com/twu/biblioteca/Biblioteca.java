package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {

    private List<Book> books;
    private List<Book> checkedOutBooks;

    public Biblioteca() {
        books = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
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
        return removeAddLoop(title, books.iterator(), checkedOutBooks);
    }

    public boolean returnBook(String title) {
        return removeAddLoop(title, checkedOutBooks.iterator(), books);
    }

    private boolean removeAddLoop(String title, Iterator<Book> itRemoveFrom, List<Book> listAddTo) {
        while (itRemoveFrom.hasNext()){
            Book book = itRemoveFrom.next();
            if (book.getTitle().equals(title)){
                itRemoveFrom.remove();
                listAddTo.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean bookWasCheckedOut(String title) {
        for (Book book : checkedOutBooks) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean bookIsIn(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

}
