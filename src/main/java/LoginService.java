import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private Map<String, String> credentialsMap;
    private static LoginService instance = null;

    private LoginService() {
        credentialsMap = new HashMap<>();
        credentialsMap.put("123-4567", "1111");
    }

    public static LoginService getInstance() {
        if(instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    public boolean login(String libraryNumber, String password) {
        if(credentialsMap.containsKey(libraryNumber) && credentialsMap.get(libraryNumber).equals(password)){
            return true;
        }
        return false;
    }
}
