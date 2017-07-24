package com.twu.biblioteca.action;

import com.twu.biblioteca.Input;

public abstract class ActionWithInput implements Action {

    Input input;

    public ActionWithInput(Input input){
        this.input = input;
    }

    String answerTo(String question){
        System.out.println(question);
        return input.read();
    }
}
