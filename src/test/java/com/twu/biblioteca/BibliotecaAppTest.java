package com.twu.biblioteca;

import org.junit.*;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.*;

import static org.mockito.Mockito.*;

import java.io.*;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Mock
    private Biblioteca bibliotecaMock;

    @Mock
    private Welcome welcomeMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaMock, welcomeMock);
        bibliotecaApp.start();
    }

    @Test
    public void testWhenRunningAppMessageIsNotEmpty(){
        BibliotecaApp.main(null);
        assertTrue(outContent.toString().trim().contains(new Welcome().WelcomeMessage));
    }

    @Test
    public void testWhenRunningAppListOfBooksIsCalledFromBibliotecaClass(){
        verify(bibliotecaMock, times(1)).printListOfBooks();
    }

    @Test
    public void testWhenRunningAppPrintsListOfBooksAfterWelcomeMessage(){
        InOrder inOrder = inOrder(welcomeMock, bibliotecaMock);
        inOrder.verify(welcomeMock).printMessage();
        inOrder.verify(bibliotecaMock).printListOfBooks();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}