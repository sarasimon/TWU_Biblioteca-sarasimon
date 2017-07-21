package com.twu.biblioteca.action;

import com.twu.biblioteca.Input;
import com.twu.biblioteca.StoreInterface;

public abstract class Action {

    StoreInterface store;
    Input input;

    public Action(){
    }

    public Action(StoreInterface store){
        this.store = store;
    }

    public Action(StoreInterface store, Input input) {
        this.store = store;
        this.input = input;
    }

    public Action(Input input){
        this.input = input;
    }

    public abstract boolean go();
}
