package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

public class LogInAction extends Action {

    public LogInAction(Input input) {
        super(input);
    }

    public boolean go() {
        LoginService service = LoginService.getInstance();

        System.out.println("Please, introduce your library number (format xxx-xxxx):");
        String libraryNumber = input.read();
        System.out.println("Now, your password:");
        String password = input.read();

        service.login(libraryNumber,password);

        if (service.status.equals(Status.LOGGED_IN)) {
            System.out.println("Thank you for logging in with library number " + libraryNumber);
        } else {
            System.out.println("You are not logged in. Incorrect number or/and password.");
        }
        return true;
    }
}
