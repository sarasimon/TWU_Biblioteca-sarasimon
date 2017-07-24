package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.Input;
import com.twu.biblioteca.LoginService;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class BibliotecaTest {

    Biblioteca biblioteca;

    @Mock
    private LoginService loginServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp(){
        Mockito.when(loginServiceMock.userIsLoggedIn()).thenReturn(true);
        Mockito.when(loginServiceMock.getUser()).thenReturn(new LoggedUser("",""));
        biblioteca = new Biblioteca(loginServiceMock);
    }

    @Test
    public void testBibliotecaHasPreExistingListWhenInitialised(){
        assertTrue(biblioteca.getListOfAvailable().size() > 0);
    }

    @Test
    public void testCheckOutBookLeavesListOfBooksWithOneLess(){
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        int sizeBeforeCheckOut = biblioteca.getListOfAvailable().size();
        biblioteca.checkOut(book.getTitle());
        assertEquals(sizeBeforeCheckOut - 1, biblioteca.getListOfAvailable().size());
    }

    @Test
    public void testAddBookAddsOneBookToTheBibliotecaList(){
        int initialSize = biblioteca.getListOfAvailable().size();
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        assertEquals(initialSize + 1, biblioteca.getListOfAvailable().size());
    }

    @Test
    public void testBookExistsReturnsTrueWhenTitleOfBookIsInTheListOfBooks(){
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        assertTrue(biblioteca.isAvailable(book.getTitle()));
    }

    @Test
    public void testBookExistsReturnsTrueWhenBookIsReturned() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        biblioteca.checkOut(book.getTitle());
        biblioteca.returnBook(book.getTitle());

        assertTrue(biblioteca.isAvailable(book.getTitle()));
    }

    @Test
    public void testBibliotecaCheckOutConnectsBookWithUser() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        assertEquals("Thank you! Enjoy the book", biblioteca.checkOut(book.getTitle()));
    }

    @Test
    public void testBookIsAvailableIsFalseAfterCheckingItOut() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        biblioteca.checkOut(book.getTitle());

        assertTrue(!biblioteca.isAvailable(book.getTitle()));
    }


}