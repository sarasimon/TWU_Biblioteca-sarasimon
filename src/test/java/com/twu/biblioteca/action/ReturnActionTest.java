package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.BibliotecaService;
import com.twu.biblioteca.biblioteca.LoggedUser;
import com.twu.biblioteca.biblioteca.Biblioteca;
import org.junit.*;
import org.mockito.*;
import org.mockito.junit.*;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ReturnActionTest {
    Biblioteca biblioteca;

    @Mock
    private Input inputMock;

    @Mock
    private LoginService loginServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    BibliotecaService bibliotecaService;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        biblioteca = new Biblioteca();
        bibliotecaService = new BibliotecaService(loginServiceMock, biblioteca);
    }

    @Test
    public void testSuccessfulReturnBookWillGiveASuccessfulMessage() {
        when(inputMock.read()).thenReturn("Bible");
        when(loginServiceMock.getUser()).thenReturn(new LoggedUser("", ""));
        when(loginServiceMock.userIsLoggedIn()).thenReturn(true);

        String output = "Please, give the title of the book you want to return:\n";
        output += "Thank you for returning the book.";
        bibliotecaService.checkOut("Bible");

        ReturnAction returnAction = new ReturnAction(inputMock, bibliotecaService);
        returnAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testUnSuccessfulReturnBookWillGiveAnUnSuccessfulMessage() {
        when(inputMock.read()).thenReturn("Bible");
        when(loginServiceMock.getUser()).thenReturn(new LoggedUser("", ""));
        when(loginServiceMock.userIsLoggedIn()).thenReturn(true);

        String output = "Please, give the title of the book you want to return:\n";
        output += "It wasn't possible to return the book.";

        ReturnAction returnAction = new ReturnAction(inputMock, bibliotecaService);
        returnAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }


}