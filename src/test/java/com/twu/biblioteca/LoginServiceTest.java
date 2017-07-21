package com.twu.biblioteca;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.Status;
import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {

    String libraryNumber = "123-4567";
    String password = "1111";

    @Test
    public void testLoginIsCorrectWhenUsernameAndPasswordMatch(){
        LoginService loginService = LoginService.getInstance();
        loginService.login(libraryNumber, password);
        Assert.assertEquals(Status.LOGGED_IN, loginService.status);
    }


}