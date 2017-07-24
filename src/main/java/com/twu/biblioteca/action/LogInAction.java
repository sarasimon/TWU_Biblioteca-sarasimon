package com.twu.biblioteca.action;

import com.twu.biblioteca.*;

import java.util.regex.Pattern;

public class LogInAction extends ActionWithInput {

    public LogInAction(Input input) {
        super(input);
    }

    public boolean go() {
        Pattern numberPattern = Pattern.compile("\\d{3}-\\d{4}");

        String libraryNumber = answerTo("Please, introduce your library number (format xxx-xxxx):");

        if(!libraryNumber.matches("\\d{3}-\\d{4}")){
            System.out.println("Incorrect format.");
            return go();
        }

        String password = answerTo("Now, your password:");
        loggingIn(libraryNumber, password);
        return true;
    }

    private void loggingIn(String libraryNumber, String password) {
        LoginService service = LoginService.getInstance();;
        if (service.login(libraryNumber, password)) {
            System.out.println("Thank you for logging in with library number " + libraryNumber);
        } else {
            System.out.println("You are not logged in. Incorrect number or/and password.");
        }
    }

    public String description(String number) {
        return "Option " + number + ". Log in with library number and password";
    }
}
