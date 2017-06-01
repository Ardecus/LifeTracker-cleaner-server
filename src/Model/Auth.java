package Model;

import Controller.DatabaseController;

import java.util.UUID;

public class Auth {
    public Long UserId;
    public String Name;
    public String Password;

    public Auth(String name, String password) {
        UserId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;;
        Name = name;
        Password = password;
    }

    public Auth(Long userId, String password) {
        UserId = userId;
        Password = password;
        User user = DatabaseController.GetUser(UserId.toString());
        Name = user.Name;
    }
}
