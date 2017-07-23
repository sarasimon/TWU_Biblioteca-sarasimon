package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

public abstract class ActionWithInputAndStore extends Action {

    public ActionWithInputAndStore(StoreInterface store, Input input) {
        this.store = store;
        this.input = input;
    }

}
