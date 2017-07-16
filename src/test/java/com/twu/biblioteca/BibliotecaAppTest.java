package com.twu.biblioteca;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.*;

import static org.mockito.Mockito.*;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Mock
    private Biblioteca bibliotecaMock;
    List<String> listOfBooks;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Before
    public void setUpMocks(){
        listOfBooks = new ArrayList<String>();
        listOfBooks.add("book");
        when(bibliotecaMock.getBooks()).thenReturn(listOfBooks);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testWhenRunningAppMessageIsNotEmpty(){
        BibliotecaLauncher.main(null);
        assertFalse(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testWhenRunningAppListOfBooksIsCalledFromBibliotecaClass(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaMock);
        verify(bibliotecaMock, times(1)).getBooks();
    }

    @Test
    public void testWhenRunningAppPrintsListOfBooksAfterWelcomeMessage(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaMock);
        assertEquals(bibliotecaApp.WelcomeMessage + "\n" + listOfBooks, outContent.toString().trim());
    }

}