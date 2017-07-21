package com.twu.biblioteca.blockbuster;

public class NullMovie extends Movie {

    public NullMovie() {
        super("", 0, "", 1);
        setAsUnavailable();
    }
}
