package com.twu.biblioteca;

import java.util.*;

public class LoginService {

    private Map<String, String> credentialsMap;
    private static LoginService instance = null;
    public Status status;

    private LoginService() {
        credentialsMap = new HashMap<>();
        credentialsMap.put("123-4567", "1111");
        credentialsMap.put("111-1111", "1111");
        status = Status.UNLOGGED;
    }

    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    public void login(String libraryNumber, String password) {
        if (validCredentials(libraryNumber, password)) {
            status = Status.LOGGED_IN;
        } else {
            status = Status.UNLOGGED;
        }
    }

    private boolean validCredentials(String libraryNumber, String password) {
        return credentialsMap.containsKey(libraryNumber) && credentialsMap.get(libraryNumber).equals(password);
    }
}
