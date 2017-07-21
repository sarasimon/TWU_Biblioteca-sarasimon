import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {

    String libraryNumber = "123-4567";
    String password = "1111";

    @Test
    public void testLoginIsCorrectWhenUsernameAndPasswordMatch(){
        LoginService loginService = LoginService.getInstance();
        assertTrue(loginService.login(libraryNumber, password));
    }

}