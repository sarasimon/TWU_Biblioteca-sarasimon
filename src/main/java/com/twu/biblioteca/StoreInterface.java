package com.twu.biblioteca;

import java.util.List;

public interface StoreInterface {

    public boolean checkOut(String name);

    public String element();

    boolean isAvailable(String title);

    public List<? extends Rentable> getListOfAvailable();
}
