package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.StoreInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca implements StoreInterface {

    private List<Book> books;
    private List<Book> checkedOutBooks;

    public String element() {
        return "book";
    }

    public Biblioteca() {
        books = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        books.add(new Book("Bible", "Jesus", 0));
        books.add(new Book("Refactoring", "M. Fowler", 1990));
    }

    public List<Book> getListOfAvailable() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean returnBook(String title) {
        return removeAddLoop(title, checkedOutBooks.iterator(), books);
    }

    public boolean checkOut(String title) {
        return removeAddLoop(title, books.iterator(), checkedOutBooks);
    }

    public boolean bookWasCheckedOut(String title) {
        return listLoop(title, checkedOutBooks);
    }

    public boolean isAvailable(String title) {
        return listLoop(title, books);
    }

    private boolean removeAddLoop(String title, Iterator<Book> itRemoveFrom, List<Book> listAddTo) {
        while (itRemoveFrom.hasNext()){
            Book book = itRemoveFrom.next();
            if (book.getTitle().equals(title)){
                itRemoveFrom.remove();
                listAddTo.add(book);
            }
        }
        return true;
    }

    private boolean listLoop(String title, List<Book> list) {
        for (Book book : list) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
