package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.biblioteca.Book;
import org.junit.Test;

import java.lang.reflect.Method;

public class BookTest {

//    Side case
//    @Test
//    public void testBooksContainDetailsOfAuthorNonNullAndYear(){
//        Book book = new Book(null, -100);
//        String author = book.getAuthor();
//        Integer yearPublished = book.getYearPublished();
//        assertTrue(author != null);
//        assertTrue(yearPublished > 0);
//    }

    @Test
    public void testBooksContainDetailsOfAuthor() throws NoSuchMethodException {
        Object bookObject = new Book("A","B", 0);
        Class<?> bookClass = bookObject.getClass();
        Method author = bookClass.getMethod("getAuthor");
        Method yearPublished = bookClass.getMethod("getYearPublished");
    }



}