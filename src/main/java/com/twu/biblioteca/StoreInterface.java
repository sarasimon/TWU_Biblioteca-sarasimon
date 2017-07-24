package com.twu.biblioteca;
import com.twu.biblioteca.biblioteca.User;

import java.util.List;

public interface StoreInterface {

    String checkOut(String title);

    String element();

    boolean isAvailable(String title);

    List<? extends Rentable> getListOfAvailable();
}
