package com.twu.biblioteca.blockbuster;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testRatingIsNotBiggerThan10(){
        Movie movie = new Movie("",1, "", 11);
        assertTrue(movie.getRating() <= 10);
    }

    @Test
    public void testRatingIsNotSmallerThan1(){
        Movie movie = new Movie("",1, "", 0);
        assertTrue(movie.getRating() > 0);
    }

}