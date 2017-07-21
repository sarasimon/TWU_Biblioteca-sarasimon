package com.twu.biblioteca;

import com.twu.biblioteca.biblioteca.Biblioteca;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;

    @Mock
    private Input inputMock;

    @Mock
    private Biblioteca bibliotecaMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testWhenInvalidOptionIsChosenInputIsCalledTwiceUntilItFindsValidOption() {
        when(inputMock.read()).thenReturn("0").thenReturn("1").thenReturn("q");
        menu = new Menu(inputMock);
        menu.open();

        verify(inputMock, times(3)).read();
    }

    @Test
    public void testWhenValidOptionIsChosen3TimesInputIsCalledUntilWeExit() {
        when(inputMock.read()).thenReturn("1").thenReturn("1").thenReturn("q");
        menu = new Menu(inputMock);
        menu.open();

        verify(inputMock, times(3)).read();
    }

    @Test
    public void testWhenEnteredQWillExitTheProgram() {
        when(inputMock.read()).thenReturn("0").thenReturn("q");
        menu = new Menu(inputMock);
        menu.open();

        verify(inputMock, times(2)).read();
    }
}