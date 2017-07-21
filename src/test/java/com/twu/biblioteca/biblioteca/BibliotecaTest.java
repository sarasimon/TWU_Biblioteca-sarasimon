package com.twu.biblioteca.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;

public class BibliotecaTest {

    Biblioteca biblioteca;

    @Test
    public void testBibliotecaHasPreExistingListWhenInitialised(){
        biblioteca = new Biblioteca();
        assertTrue(biblioteca.getListOfAvailable().size() > 0);
    }

    @Test
    public void testCheckOutBookLeavesListOfBooksWithOneLess(){
        biblioteca = new Biblioteca();
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        int sizeBeforeCheckOut = biblioteca.getListOfAvailable().size();
        biblioteca.checkOut(book.getTitle());
        assertEquals(sizeBeforeCheckOut - 1, biblioteca.getListOfAvailable().size());
    }

    @Test
    public void testAddBookAddsOneBookToTheBibliotecaList(){
        biblioteca = new Biblioteca();
        int initialSize = biblioteca.getListOfAvailable().size();
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        assertEquals(initialSize + 1, biblioteca.getListOfAvailable().size());
    }

    @Test
    public void testBookExistsReturnsTrueWhenTitleOfBookIsInTheListOfBooks(){
        biblioteca = new Biblioteca();
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        assertTrue(biblioteca.isAvailable(book.getTitle()));
    }

    @Test
    public void testBookExistsReturnsTrueWhenBookIsReturned() {
        biblioteca = new Biblioteca();
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        biblioteca.checkOut(book.getTitle());
        biblioteca.returnBook(book.getTitle());

        assertTrue(biblioteca.isAvailable(book.getTitle()));
    }


}