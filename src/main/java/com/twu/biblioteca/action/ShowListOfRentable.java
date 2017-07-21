package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

public abstract class ShowListOfRentable extends Action {

    abstract String headersInColumns();
    abstract String detailsInColumns(Rentable iRentable);

    public ShowListOfRentable(StoreInterface biblioteca) {
        super(biblioteca);
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
