package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OptionsTest {

    @Mock
    private Biblioteca bibliotecaMock;

    @Mock
    private Input inputMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testWhenPressOption1PrintsListOfBooks() {
        when(inputMock.read()).thenReturn("1");

        Options options = new Options(bibliotecaMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(bibliotecaMock, times(1)).getListOfBooks();
    }

    @Test
    public void testWhenPress3ReturnMethodInBibliotecaIsCalled() {
        when(inputMock.read()).thenReturn("3");
        when(bibliotecaMock.bookWasCheckedOut(anyString())).thenReturn(true);

        Options options = new Options(bibliotecaMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(bibliotecaMock, times(1)).returnBook(anyString());
    }

}