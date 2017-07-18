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
    public void testWhenRunningAppPrintsListOfBooksAfterAskingForOption1(){
        when(menuInputMock.readOption()).thenReturn("1");
        Menu menu = new Menu(menuInputMock, menuOutputMock);

        menu.printOptions();
        menu.readOption();

        verify(menuOutputMock, times(1)).printListOfBooks();
    }
}