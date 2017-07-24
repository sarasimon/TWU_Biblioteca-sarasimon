package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.LoginService;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class BibliotecaTest {

    Biblioteca biblioteca;
    BibliotecaService bibliotecaService;

    @Mock
    private LoginService loginServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        Mockito.when(loginServiceMock.userIsLoggedIn()).thenReturn(true);
        Mockito.when(loginServiceMock.getUser()).thenReturn(new LoggedUser("", ""));
        biblioteca = new Biblioteca();
        bibliotecaService = new BibliotecaService(loginServiceMock, biblioteca);
    }

    @Test
    public void testBibliotecaHasPreExistingListWhenInitialised() {
        assertTrue(bibliotecaService.getListOfAvailable().size() > 0);
    }

    @Test
    public void testCheckOutBookLeavesListOfBooksWithOneLess() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        int sizeBeforeCheckOut = bibliotecaService.getListOfAvailable().size();
        bibliotecaService.checkOut(book.getTitle());
        assertEquals(sizeBeforeCheckOut - 1, bibliotecaService.getListOfAvailable().size());
    }

    @Test
    public void testAddBookAddsOneBookToTheBibliotecaList() {
        int initialSize = bibliotecaService.getListOfAvailable().size();
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        assertEquals(initialSize + 1, bibliotecaService.getListOfAvailable().size());
    }

    @Test
    public void testBookExistsReturnsTrueWhenTitleOfBookIsInTheListOfBooks() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        assertTrue(bibliotecaService.isAvailable(book.getTitle()));
    }

    @Test
    public void testBookExistsReturnsTrueWhenBookIsReturned() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        bibliotecaService.checkOut(book.getTitle());
        bibliotecaService.returnBook(book.getTitle());

        assertTrue(bibliotecaService.isAvailable(book.getTitle()));
    }

    @Test
    public void testBibliotecaCheckOutConnectsBookWithUser() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);

        assertEquals("Thank you! Enjoy the book", bibliotecaService.checkOut(book.getTitle()));
    }

    @Test
    public void testBookIsAvailableIsFalseAfterCheckingItOut() {
        Book book = new Book("TDD", "Ken Beck", 1900);
        biblioteca.addBook(book);
        bibliotecaService.checkOut(book.getTitle());

        assertTrue(!bibliotecaService.isAvailable(book.getTitle()));
    }


}