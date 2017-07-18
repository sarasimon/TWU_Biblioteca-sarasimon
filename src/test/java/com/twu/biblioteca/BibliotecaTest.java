package com.twu.biblioteca;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ArrayList<Book> listOfBooks;
    Biblioteca biblioteca;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        listOfBooks = new ArrayList<Book>();
        biblioteca = new Biblioteca(listOfBooks);
    }

    @Test
    public void testInformationOfOneBookIsDisplayedInColumns() {
        Book book = new Book("Tom Mot", 1900);
        listOfBooks.add(book);
        biblioteca.printListOfBooks();

        String outputInColumns = String.format(Biblioteca.BOOKDISPLAYFORMAT, "Author", "Year Published");
        outputInColumns += String.format(Biblioteca.BOOKDISPLAYFORMAT, book.getAuthor(), book.getYearPublished());

        assertEquals(outputInColumns.trim(), outContent.toString().trim());
    }

    @Test
    public void testInformationOfThreeBooksIsDisplayedInColumns() {
        Book book = new Book("Tom Mot", 1900);
        Book book2 = new Book("Mat Tam", 1800);
        Book book3 = new Book("Roy Yor", 1700);
        listOfBooks.add(book);
        listOfBooks.add(book2);
        listOfBooks.add(book3);

        biblioteca.printListOfBooks();

        String outputInColumns = String.format(Biblioteca.BOOKDISPLAYFORMAT, "Author", "Year Published");
        outputInColumns += String.format(Biblioteca.BOOKDISPLAYFORMAT, book.getAuthor(), book.getYearPublished());
        outputInColumns += String.format(Biblioteca.BOOKDISPLAYFORMAT, book2.getAuthor(), book2.getYearPublished());
        outputInColumns += String.format(Biblioteca.BOOKDISPLAYFORMAT, book3.getAuthor(), book3.getYearPublished());

        assertEquals(outputInColumns.trim(), outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}