package Tests;

import Exceptions.InvalidPasswordException;
import beans.User;

public class TestUser {
    public static void main(String[] args) {
        try {
            User user = new User( "test@test.fr", "test123");
            System.out.println(user.exist());
        } catch (InvalidPasswordException e) {
            throw new RuntimeException(e);
        }
//        user.creatUser();
//        if (user.checkPasswordAndLogin("admin", "test")) {
//            System.out.println("JsonFactory!");
//        }
    }
}
