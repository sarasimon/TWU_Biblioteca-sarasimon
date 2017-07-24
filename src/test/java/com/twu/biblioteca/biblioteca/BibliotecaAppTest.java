package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.Input;
import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.Menu;
import com.twu.biblioteca.Options;
import com.twu.biblioteca.action.ActionFactory;
import com.twu.biblioteca.blockbuster.Blockbuster;
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
//    Options options = new Options(new Biblioteca(), new Input()).ask();

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
    public void testWhenRunningAppMessageIsWelcomeMessage() {
        when(inputMock.read()).thenReturn("7");
        bibliotecaApp.start(new Menu(inputMock));
        assertTrue(outContent.toString().trim().contains("***************** Welcome to \"la Biblioteca\" *****************"));
    }

    @Test
    public void testWhenRunningAppPrintsListOfOptionsAfterWelcomeMessage() {
        when(inputMock.read()).thenReturn("7");
        bibliotecaApp.start(new Menu(inputMock));
        String output = "***************** Welcome to \"la Biblioteca\" *****************\n";
        output += "\nThis is the menu: (Press number and Intro to select an option)\n";
        ActionFactory actionFactory = ActionFactory.createActionFactory(new Input(), new Biblioteca(LoginService.getInstance()), new Blockbuster());
        output += actionFactory.stringOfActions();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenRunningAppReturnsInvalidMessageWhenOptionIsInvalid() {
        when(inputMock.read()).thenReturn("0").thenReturn("7");
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start(new Menu(inputMock));
        String output = "***************** Welcome to \"la Biblioteca\" *****************\n";
        output += "\nThis is the menu: (Press number and Intro to select an option)\n";
        ActionFactory actionFactory = ActionFactory.createActionFactory(new Input(), new Biblioteca(LoginService.getInstance()), new Blockbuster());
        output += actionFactory.stringOfActions();

        output += "\nSelect a valid option!\n";
        output += "\nThis is the menu: (Press number and Intro to select an option)\n";
        output += actionFactory.stringOfActions();

        assertEquals(output.trim(), outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}