package com.twu.biblioteca.blockbuster;

import org.junit.Test;
import static org.junit.Assert.*;

public class BlockbusterTest {

    @Test
    public void testCheckOutMovieLeavesMovieUnavailable(){
        Blockbuster blockbuster = new Blockbuster();
        blockbuster.addMovie(new Movie("Titanic", 1998, "James Cameron",1));
        blockbuster.checkOut("Titanic");

        assertFalse(blockbuster.getMovie("Titanic").isAvailable());
    }

    @Test
    public void testGetMovieThatDoesNotExistReturnsNullMovie(){
        Blockbuster blockbuster = new Blockbuster();

        assertTrue(blockbuster.getMovie("Titanic") instanceof NullMovie);
    }

    @Test
    public void testCheckOutMovieLeavesListOfMoviesWithOneLess(){
        Blockbuster blockbuster = new Blockbuster();
        blockbuster.addMovie(new Movie("Titanic", 1998, "James Cameron",1));
        int sizeBeforeCheckOut = blockbuster.getListOfAvailable().size();

        blockbuster.checkOut("Titanic");
        assertEquals(sizeBeforeCheckOut - 1, blockbuster.getListOfAvailable().size());
    }

}