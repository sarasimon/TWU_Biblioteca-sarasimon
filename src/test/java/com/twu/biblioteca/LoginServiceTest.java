package com.twu.biblioteca;

import com.twu.biblioteca.action.LogInAction;
import com.twu.biblioteca.biblioteca.Biblioteca;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.when;

public class LoginServiceTest {

    String libraryNumber = "123-4567";
    String password = "1111";

    @Mock
    Input inputMock;

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
    public void testLoginIsCorrectWhenUsernameAndPasswordMatch(){
        LoginService loginService = LoginService.getInstance();
        loginService.login(libraryNumber, password);
        Assert.assertTrue(loginService.userIsLoggedIn());
    }

    @Test
    public void testLoginReturnsErrorMessageWhenFormatOfLibraryNumberIsIncorrect(){
        when(inputMock.read()).thenReturn("1").thenReturn(libraryNumber).thenReturn(password);
        LogInAction logInAction = new LogInAction(inputMock);

        String output = "Please, introduce your library number (format xxx-xxxx):\n";
        output += "Incorrect format.\n";
        output += "Please, introduce your library number (format xxx-xxxx):\n";
        output += "Now, your password:\n";
        output += "Thank you for logging in with library number " + libraryNumber;

        logInAction.go();

        Assert.assertEquals(output, outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


}