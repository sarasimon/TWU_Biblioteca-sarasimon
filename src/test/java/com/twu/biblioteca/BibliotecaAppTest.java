package com.twu.biblioteca;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.*;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    BibliotecaApp bibliotecaApp;

    @Mock
    private MenuInput menuInputMock;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        when(menuInputMock.readOption()).thenReturn("0");
        bibliotecaApp = new BibliotecaApp(new Menu(menuInputMock,new MenuOutput()));
    }

    @Test
    public void testWhenRunningAppMessageIsWelcomeMessage(){
        bibliotecaApp.start();
        assertTrue(outContent.toString().trim().contains("***************** Welcome to \"la Biblioteca\" *****************"));
    }


    @Test
    public void testWhenRunningAppPrintsListOfOptionsAfterWelcomeMessage(){
        bibliotecaApp.start();
        String output = "***************** Welcome to \"la Biblioteca\" *****************";
        output += "\nThis is the menu: (Press number and Intro to select an option)";
        output += "\nOption 1. Show List Of Books";

        assertEquals(outContent.toString().trim(), output);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}