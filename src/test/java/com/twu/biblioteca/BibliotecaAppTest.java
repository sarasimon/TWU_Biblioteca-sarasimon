package com.twu.biblioteca;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.*;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Mock
    private Input inputMock;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testWhenRunningAppMessageIsWelcomeMessage(){
        when(inputMock.read()).thenReturn("q");
        bibliotecaApp.start(new Menu(inputMock, new MenuOutput()));
        assertTrue(outContent.toString().trim().contains("***************** Welcome to \"la Biblioteca\" *****************"));
    }


    @Test
    public void testWhenRunningAppPrintsListOfOptionsAfterWelcomeMessage(){
        when(inputMock.read()).thenReturn("q");
        bibliotecaApp.start(new Menu(inputMock, new MenuOutput()));
        String output = "***************** Welcome to \"la Biblioteca\" *****************";
        output += "\nThis is the menu: (Press number and Intro to select an option)";
        output += "\nOption 1. Show List Of Books";

        assertTrue(outContent.toString().trim().contains(output));
    }

    @Test
    public void testWhenRunningAppReturnsInvalidMessageWhenOptionIsInvalid(){
        when(inputMock.read()).thenReturn("0").thenReturn("q");
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start(new Menu(inputMock, new MenuOutput()));
        String output = "***************** Welcome to \"la Biblioteca\" *****************\n";
        output += "This is the menu: (Press number and Intro to select an option)\n";
        output += "Option 1. Show List Of Books (Press 1)\n";
        output += "Option 2. Check out a book (Insert title of the book)\n";
        output += "Option 3. Quit de program (press \"q\")\n";
        output += "Select a valid option!\n";
        output += "This is the menu: (Press number and Intro to select an option)\n";
        output += "Option 1. Show List Of Books (Press 1)\n";
        output += "Option 2. Check out a book (Insert title of the book)\n";
        output += "Option 3. Quit de program (press \"q\")\n";

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}