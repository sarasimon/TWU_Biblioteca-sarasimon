package com.twu.biblioteca;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.BibliotecaApp;
import org.junit.*;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Mock
    Biblioteca bibliotecaMock;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testWhenRunningAppMessageIsNotEmpty(){
        BibliotecaApp.main(null);
        assertFalse(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testWhenRunningAppListOfBooksIsCalledFromBibliotecaClass(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaMock);
        verify(bibliotecaMock, times(1)).getBooks();
    }

}