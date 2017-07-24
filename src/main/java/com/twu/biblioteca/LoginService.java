package com.twu.biblioteca;

import com.twu.biblioteca.biblioteca.LoggedUser;
import com.twu.biblioteca.biblioteca.NoUser;
import com.twu.biblioteca.biblioteca.User;

import java.util.*;

public class LoginService {

    private List<LoggedUser> loggedUsersList;
    private static LoginService instance = null;
    private User user;

    public User getUser() {
        return user;
    }

    public boolean userIsLoggedIn(){
        return user instanceof LoggedUser;
    }

    private LoginService() {
        loggedUsersList = new ArrayList<>();
        loggedUsersList.add(new LoggedUser("123-4567", "1111"));
        loggedUsersList.add(new LoggedUser("111-1111", "1111"));
        user = new NoUser();
    }

    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    public boolean login(String libraryNumber, String password) {
        for (LoggedUser loggedUser : loggedUsersList) {
            if (isUserAuth(libraryNumber, password, loggedUser)){
                user = loggedUser;
                return true;
            }
        }
        return false;
    }

    public void logout(){
        user = new NoUser();
    }

    private boolean isUserAuth(String libraryNumber, String password, LoggedUser loggedUser) {
        return loggedUser.getLibraryNumber().equals(libraryNumber) &&
                loggedUser.getPassword().equals(password);
    }
}
