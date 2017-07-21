package com.twu.biblioteca.action;

import com.twu.biblioteca.StoreInterface;

public abstract class Action {

    StoreInterface store;

    public Action(){
    }

    public Action(StoreInterface store) {
        this.store = store;
    }

    public abstract boolean go();
}
