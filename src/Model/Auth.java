package Model;

import Controller.DatabaseController;

import java.util.Base64;

public class Auth extends Identified{
    public String Name;
    public String Password;

    public Auth() {
        GenerateId();
    }

    public Auth(String name, String password) {
        GenerateId();
        Name = name;
        Password = password;
    }

    public Auth(Long id, String password) {
        Id = id;
        Password = password;
        User user = DatabaseController.getInstance().GetUser(Id.toString());
        Name = user.Name;
    }

    public String GetToken() {
        return Base64.getEncoder().encodeToString(Password.getBytes());
    }
}
