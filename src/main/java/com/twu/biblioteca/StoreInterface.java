package com.twu.biblioteca;

import java.util.List;

public interface BibliotecaInterface {

    public boolean checkOut(String name);

    public final String element = "";

    boolean isAvailable(String title);

    public List<? extends Rentable> getListOfAvailable();
}
