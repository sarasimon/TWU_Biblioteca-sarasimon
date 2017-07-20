package com.twu.biblioteca;

public abstract class Action {

    Biblioteca biblioteca;

    public Action(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public abstract void go();
}
