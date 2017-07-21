package com.twu.biblioteca;

import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.blockbuster.Blockbuster;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OptionsTest {

    @Mock
    private Biblioteca bibliotecaMock;

    @Mock
    private Blockbuster blockbusterMock;

    @Mock
    private Input inputMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testWhenPressOption1PrintsListOfAvailableBooks() {
        when(inputMock.read()).thenReturn("1");

        Options options = new Options(bibliotecaMock, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(bibliotecaMock, times(1)).getListOfAvailable();
    }

    @Test
    public void testWhenPress3ReturnMethodInBibliotecaIsCalled() {
        when(inputMock.read()).thenReturn("3");
        when(bibliotecaMock.bookWasCheckedOut(anyString())).thenReturn(true);

        Options options = new Options(bibliotecaMock, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(bibliotecaMock, times(1)).returnBook(anyString());
    }

    @Test
    public void testWhenPress5checkOutMethodInBibliotecaIsCalled() {
        when(inputMock.read()).thenReturn("5");
        when(blockbusterMock.isAvailable(anyString())).thenReturn(true);

        Options options = new Options(bibliotecaMock, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(blockbusterMock, times(1)).checkOut(anyString());
    }

    @Test
    public void testWhenPress4PrintsListOfAvailableMovies() {
        when(inputMock.read()).thenReturn("4");

        Options options = new Options(bibliotecaMock, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(blockbusterMock, times(1)).getListOfAvailable();
    }

    @Test
    public void testWhenPress5PrintsListOfAvailableMovies() {
        when(inputMock.read()).thenReturn("4");

        Options options = new Options(bibliotecaMock, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(blockbusterMock, times(1)).getListOfAvailable();
    }

}