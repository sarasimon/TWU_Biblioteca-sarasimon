package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;

public abstract class ActionWithStore implements Action {

    StoreInterface store;

    public ActionWithStore(StoreInterface store){
        this.store = store;
    }
}
