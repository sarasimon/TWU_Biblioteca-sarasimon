package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

public abstract class ShowListOfRentable extends ActionWithStore {

    abstract String headersInColumns();
    abstract String detailsInColumns(Rentable iRentable);

    public ShowListOfRentable(StoreInterface store) {
        super(store);
    }

    public String description(String number) {
        return "Option " + number + ". Show list of " + store.element();
    }

    public boolean go() {
        String outputInColumns = headersInColumns();
        for (Rentable iRentable : store.getListOfAvailable()) {
            outputInColumns += detailsInColumns(iRentable);
        }
        System.out.println(outputInColumns);
        return true;
    }
}
