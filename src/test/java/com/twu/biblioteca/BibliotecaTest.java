package com.twu.biblioteca;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {

    Biblioteca biblioteca;

    @Test
    public void testBibliotecaHasPreExistingListWhenInitialised(){
        biblioteca = new Biblioteca();
        assertTrue(biblioteca.getListOfBooks().size() > 0);
    }


}