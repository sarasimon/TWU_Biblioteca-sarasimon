package com.twu.biblioteca.action;

import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.Input;
import org.junit.*;
import org.mockito.*;
import org.mockito.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CheckOutActionTest {

    @Mock
    private Input inputMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testWhenCheckingOutTheBookFromMenuWillReduceTheSizeOfTheListOfBooks() {
        when(inputMock.read()).thenReturn("Bible");
        Biblioteca biblioteca = new Biblioteca();
        int initialSize = biblioteca.getListOfAvailable().size();

        CheckOutAction checkOutAction = new CheckOutAction(inputMock, biblioteca);
        checkOutAction.go();

        Assert.assertEquals(initialSize - 1, biblioteca.getListOfAvailable().size());
    }

    @Test
    public void testWhenCheckingOutABookSuccessfullyReturnsSuccessfulMessage(){
        when(inputMock.read()).thenReturn("Bible");
        String output = "Please, give the book you want to check out:\n";
        output += "Thank you! Enjoy the book";
        Biblioteca biblioteca = new Biblioteca();

        CheckOutAction checkOutAction = new CheckOutAction(inputMock, biblioteca);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCheckingOutABookUnsuccessfullyReturnsUnsuccessfulMessage(){
        when(inputMock.read()).thenReturn("B").thenReturn("7");
        String output = "Please, give the book you want to check out:\n";
        output += "That book is not available. Please try again.";
        Biblioteca biblioteca = new Biblioteca();

        CheckOutAction checkOutAction = new CheckOutAction(inputMock, biblioteca);
        checkOutAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }

}