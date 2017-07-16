package com.twu.biblioteca;

import com.twu.biblioteca.Biblioteca;
import org.junit.*;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void testListOfLibrary(){
        Biblioteca biblioteca = new Biblioteca();
        assertTrue(biblioteca.getBooks().size() > 0);
    }

}