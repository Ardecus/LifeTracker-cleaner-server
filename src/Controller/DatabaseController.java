package Controller;

import Model.*;

import java.util.ArrayList;

//Nata's stuff
public class DatabaseController {
    //Db provides data, main controller turns into json?
    //GET
    //если запись по айдишнику не найдена - возвращает null

    //всякие трайкэтчи и проверки на адекватность параметров должны быть в MainController, а не здесь
    public static User GetUser(String userid) {
        return new User();
    } //yep, like this
    public static Panel GetPanel(String panelid) {
        return new Panel();
    }
    public static Panel[] GetPanels(String userid) {
        return new Panel[1];
    }
    public static Activity GetActivity(String activityid) {
        return new Activity();
    }
    public static Activity[] GetActivities(String panelid) {
        return new Activity[1];
    }
    public static Check GetCheck(String checkid) {
        return new Check();
    }
    public static Check[] GetChecks(String activityid) {
        return new Check[1];
    }

    //POST
    public static void PostUser(User user) {}
    public static void PostPanel(Panel panel){}
    public static void PostActivity(Activity activity) {}
    public static void PostCheck(Check check) {}

    //PUT
    public static void PutUser(User user) {}
    public static void PutPanel(Panel panel){}
    public static void PutActivity(Activity activity) {}

    //DELETE
    public static void DeleteUser(String userid) {}
    public static void DeletePanel(String panelid){}
    public static void DeleteActivity(String activityid) {}
}
