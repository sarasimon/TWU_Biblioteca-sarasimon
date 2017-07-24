package com.twu.biblioteca.action;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.Input;
import com.twu.biblioteca.blockbuster.Blockbuster;
import org.junit.*;
import org.mockito.*;
import org.mockito.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class CheckOutActionTest {

    @Mock
    private Input inputMock;

    @Mock
    private LoginService loginServiceMock;

    @Mock
    private Biblioteca bibliotecaMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    Biblioteca biblioteca;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        when(loginServiceMock.userIsLoggedIn()).thenReturn(true);
        biblioteca = new Biblioteca(loginServiceMock);
        LoginService.getInstance().login("111-1111","1111");
    }

    @Test
    public void testWhenCheckingOutTheBookFromMenuWillReduceTheSizeOfTheListOfBooks() {
        when(inputMock.read()).thenReturn("Bible");
        int initialSize = biblioteca.getListOfAvailable().size();

        biblioteca.checkOut("Bible");

        Assert.assertEquals(initialSize - 1, biblioteca.getListOfAvailable().size());
    }

    @Test
    public void testWhenCheckingOutABookSuccessfullyReturnsSuccessfulMessage() {
        when(bibliotecaMock.checkOut(anyString())).thenReturn("Thank you! Enjoy the book");
        when(bibliotecaMock.element()).thenReturn("book");

        String output = "Please, give the book you want to check out:\n";
        output += "Thank you! Enjoy the book";

        CheckOutAction checkOutAction = new CheckOutAction(bibliotecaMock, inputMock);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutABookUnsuccessfullyReturnsUnsuccessfulMessage() {
        when(inputMock.read()).thenReturn("B").thenReturn("7");

        String output = "Please, give the book you want to check out:\n";
        output += "That book is not available. Please try again.";

        CheckOutAction checkOutAction = new CheckOutAction(biblioteca, inputMock);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutABookAfterLoggingInReturnsSuccessfulMessage() {
        when(inputMock.read()).thenReturn("Bible").thenReturn("7");

        String output = "Please, give the book you want to check out:\n";
        output += "Thank you! Enjoy the book";

        CheckOutAction checkOutAction = new CheckOutAction(biblioteca, inputMock);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutABookWithoutLoggingReturnsMessage() {
        when(inputMock.read()).thenReturn("B").thenReturn("7");
        LoginService.getInstance().logout();
        String output = "You are not logged in.";

        CheckOutAction checkOutAction = new CheckOutAction(biblioteca, inputMock);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutAMovieUnsuccessfullyReturnsUnsuccessfulMessage() {
        when(inputMock.read()).thenReturn("B").thenReturn("7");

        String output = "Please, give the movie you want to check out:\n";
        output += "That movie is not available. Please try again.";

        CheckOutAction checkOutAction = new CheckOutAction(new Blockbuster(), inputMock);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutAMovieSuccessfullyReturnsSuccessfulMessage() {
        when(inputMock.read()).thenReturn("Pulp Ficcion").thenReturn("7");

        String output = "Please, give the movie you want to check out:\n";
        output += "Thank you! Enjoy the movie.";

        CheckOutAction checkOutAction = new CheckOutAction(new Blockbuster(), inputMock);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutABookWithoutLoggingDoesNotCheckOut() {
        when(inputMock.read()).thenReturn("Bible");
        LoginService.getInstance().logout();

        int initialSize = biblioteca.getListOfAvailable().size();

        CheckOutAction checkOutAction = new CheckOutAction(biblioteca, inputMock);
        checkOutAction.go();

        Assert.assertEquals(initialSize, biblioteca.getListOfAvailable().size());
    }

}