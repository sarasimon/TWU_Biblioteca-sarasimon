package com.twu.biblioteca.biblioteca;

import java.util.Objects;

public class LoggedUser implements User {

    public String getLibraryNumber() {
        return libraryNumber;
    }

    private final String libraryNumber;

    public String getPassword() {
        return password;
    }

    private final String password;

    public LoggedUser(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;
        User user = (User) o;

        return Objects.equals(libraryNumber, user.getLibraryNumber())
                && Objects.equals(password, user.getPassword());
    }
}
