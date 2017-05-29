package Controller;

//Nata's stuff
public class DatabaseController {
    //Db provides data, main controller turns into json?
    //GET
    //если запись по айдишнику не найдена - возвращает пустую строку

    //всякие трайкэтчи и проверки на адекватность параметров должны быть в MainController, а не здесь
    public static String GetUser(String userid) {
        return "GetUser" + userid;
    }
    public static String GetPanel(String panelid) {
        return "GetUsers" + panelid;
    }
    public static String GetPanels(String userid) {
        return "GetPanels of user " + userid;
    }
    public static String GetActivity(String activityid) {
        return "GetActivity" + activityid;
    }
    public static String GetActivities(String panelid) {
        return "GetActivities from panel " + panelid;
    }
    public static String GetCheck(String checkid) {
        return "GetCheck" + checkid;
    }
    public static String GetChecks(String activityid) {
        return "GetChecks from activity " + activityid;
    }

    //POST
    public static void PostUser(String[] params) {}
    public static void PostActivityPanel(String[] params){}
    public static void PostActivity(String[] params) {}
    public static void PostCheck(String[] params) {}

    //PUT

    //DELETE
}
