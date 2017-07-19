package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class MenuTest {

    @Mock
    private MenuOutput menuOutputMock;

    @Mock
    private MenuInput menuInputMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testWhenPressOption1PrintsListOfBooks(){
        when(menuInputMock.read()).thenReturn("1").thenReturn("q");
        Menu menu = new Menu(menuInputMock, menuOutputMock);
        menu.open();

        verify(menuOutputMock, times(1)).printListOfBooks();
    }

    @Test
    public void testWhenInvalidOptionIsChosenInputIsCalledTwiceUntilItFindsValidOption(){
        when(menuInputMock.read()).thenReturn("0").thenReturn("1").thenReturn("q");
        Menu menu = new Menu(menuInputMock, menuOutputMock);
        menu.open();

        verify(menuInputMock, times(3)).read();
    }

    @Test
    public void testWhenValidOptionIsChosen3TimesInputIsCalledUntilWeExit(){
        when(menuInputMock.read()).thenReturn("1").thenReturn("1").thenReturn("q");
        Menu menu = new Menu(menuInputMock, menuOutputMock);
        menu.open();

        verify(menuInputMock, times(3)).read();
    }

    @Test
    public void testWhenEnteredQWillExitTheProgram(){
        when(menuInputMock.read()).thenReturn("0").thenReturn("q");
        Menu menu = new Menu(menuInputMock, menuOutputMock);
        menu.open();

        verify(menuInputMock, times(2)).read();
    }
}