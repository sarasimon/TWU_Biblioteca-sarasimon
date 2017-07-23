package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

public class LogInAction extends ActionWithInput {

    public LogInAction(Input input) {
        super(input);
    }

    public boolean go() {
        LoginService service = LoginService.getInstance();

        String libraryNumber = answerTheQuestion("Please, introduce your library number (format xxx-xxxx):");
        String password = answerTheQuestion("Now, your password:");
        service.login(libraryNumber, password);

        if (service.status.equals(Status.LOGGED_IN)) {
            System.out.println("Thank you for logging in with library number " + libraryNumber);
        } else {
            System.out.println("You are not logged in. Incorrect number or/and password.");
        }
        return true;
    }

    public String description(String s) {
        return "Option " + s + ". Log in with library number and password";
    }
}
