package com.twu.biblioteca;
import com.twu.biblioteca.biblioteca.User;

import java.util.List;

public interface StoreInterface {

    String element();

    boolean isAvailable(String title);

    List<? extends Rentable> getListOfAvailable();

    String checkOut(String title);
}
