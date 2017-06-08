package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Model.*;

//Nata's stuff
public class DatabaseController {
    //Db provides data, main controller turns into json?
    //GET
    //если запись по айдишнику не найдена - возвращает null
    // JDBC URL, username and password of MySQL server
    private static volatile DatabaseController instance;

    public static DatabaseController getInstance() {
        DatabaseController localInstance = instance;
        if (localInstance == null) {
            synchronized (DatabaseController.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DatabaseController();
                }
            }
        }
        return localInstance;
    }

    //всякие трайкэтчи и проверки на адекватность параметров должны быть в MainController, а не здесь
    public  Auth GetAuth(String userid){
        Auth auth = new Auth();
        return auth;
    }

    public  Auth[] GetAuths() {
        Auth res = new Auth();
        ArrayList<Auth> auts = new ArrayList<Auth>();
        Auth[] a = new Auth[auts.size()];
        return auts.toArray(a);
    }

    public User[]GetUsers() {
        return new User[] {new User("Er")};
    }

    public  User GetUser(String userid) {
        User res = new User("Silvia");
        res.FriendsId = new Long[] {123L, 358L};
        return res;
    } //yep, like this
    public  Activity GetActivity(String activityid) {
        Activity res = new Activity();
        return res;
    }
    public  Activity[] GetActivities(String userid) {
        Activity res = new Activity();
        ArrayList<Activity> acts = new ArrayList<Activity>();
        Activity[] a = new Activity[acts.size()];
        return acts.toArray(a);
    }
    public  Check GetCheck(String checkid) {
        Check res = new Check(Long.parseLong(checkid));
        return res;
    }
    public  Check[] GetChecks(String activityid) {
        Check res = new Check(Long.parseLong(activityid));
        ArrayList<Check> chks = new ArrayList<Check>();
        Check[] c = new Check[chks.size()];
        return chks.toArray(c);
    }
    public  Badge[] GetBadges() {
        Badge res = new Badge(" ",0);
        ArrayList<Badge> badges = new ArrayList<Badge>();
        Badge[] b = new Badge[badges.size()];
        return badges.toArray(b);
    }

    //POST (new)
    public  void PostAuth(Auth gotten) {
    }
    public  void PostUser(User user) {
    }
    public  void PostActivity(Activity activity) {
    }
    public  void PostCheck(Check check) {
    }

    public  void PostFriend(Long id, Long friendId) {
    }

    //PUT (update)
    public  void PutAuth(Auth auth) {
    }

    public  void PutUser(User user) {
    }
    public  void PutActivity(Activity activity) {
    }

    //DELETE
    public  void DeleteUser(String userid) {
    }
    public  void DeleteActivity(String activityid) {
    }

    public  void DeleteFriend(Long id, Long friendId) {
    }

}