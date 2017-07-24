package com.twu.biblioteca;

import com.twu.biblioteca.biblioteca.Biblioteca;
import com.twu.biblioteca.biblioteca.BibliotecaService;
import com.twu.biblioteca.biblioteca.Book;
import com.twu.biblioteca.biblioteca.User;
import com.twu.biblioteca.blockbuster.Blockbuster;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.*;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class OptionsTest {

    @Mock
    private BibliotecaService bibliotecaService;

    @Mock
    private Biblioteca bibliotecaMock;

    @Mock
    private Blockbuster blockbusterMock;

    @Mock
    private Input inputMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    LoginService loginService;


    @Before
    public void setUp(){
         loginService = LoginService.getInstance();
         loginService.login("111-1111","1111");
    }

    @Test
    public void testWhenPressOption1PrintsListOfAvailableBooks() {
        when(inputMock.read()).thenReturn("1");

        Options options = new Options(bibliotecaService, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(bibliotecaService, times(1)).getListOfAvailable();
    }

    @Test
    public void testWhenPress3ReturnMethodIsNotCheckedOutInBibliotecaIsCalled() {
        when(inputMock.read()).thenReturn("3").thenReturn("Bible");

        Options options = new Options(bibliotecaService, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(bibliotecaService, times(1)).returnBook(anyString());
    }

    @Test
    public void testWhenPress5checkOutMethodInBibliotecaIsCalled() {
        when(inputMock.read()).thenReturn("5");
        when(blockbusterMock.isAvailable(anyString())).thenReturn(true);

        Options options = new Options(bibliotecaService, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(blockbusterMock, times(1)).checkOut(anyString());
    }

    @Test
    public void testWhenPress4PrintsListOfAvailableMovies() {
        when(inputMock.read()).thenReturn("4");

        Options options = new Options(bibliotecaService, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        verify(blockbusterMock, times(1)).getListOfAvailable();
    }

    @Test
    public void testWhenPress6ChecksForValidUsernameAndPasswordAndPutsLoginInterfaceIntoLoggedInStatus() {
        String libraryNumber = "123-4567";
        String password = "1111";

        when(inputMock.read()).thenReturn("6").thenReturn(libraryNumber).thenReturn(password);

        Options options = new Options(bibliotecaService, blockbusterMock, inputMock);
        options.returnOptions(inputMock.read());

        Assert.assertTrue(LoginService.getInstance().userIsLoggedIn());
    }

}