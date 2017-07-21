package com.twu.biblioteca.action;

import com.twu.biblioteca.*;
import com.twu.biblioteca.biblioteca.Biblioteca;
import org.junit.*;
import org.mockito.*;
import org.mockito.junit.*;
import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ReturnActionTest {

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
    public void testSuccessfulReturnBookWillGiveASuccessfulMessage() {
        when(inputMock.read()).thenReturn("Bible");

        String output = "Please, give the title of the book you want to return:\n";
        output += "Thank you for returning the book.";
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.checkOut("Bible");

        ReturnAction returnAction = new ReturnAction(inputMock, biblioteca);
        returnAction.go();

        assertEquals(output.trim(), outContent.toString().trim());
    }
}