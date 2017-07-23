package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

public abstract class ActionWithInputAndStore extends ActionWithInput {

    StoreInterface store;

    public ActionWithInputAndStore(StoreInterface store, Input input) {
        super(input);
        this.store = store;
    }

}
