package Controller;

import Model.*;

//Nata's stuff
public class DatabaseController {
    //Db provides data, main controller turns into json?
    //GET
    //если запись по айдишнику не найдена - возвращает null

    //всякие трайкэтчи и проверки на адекватность параметров должны быть в MainController, а не здесь
    public static Auth[] GetAuths()
    {
        return new Auth[] {new Auth(1L,"pass")};
    }

    public static User GetUser(String userid) {
        User res = new User("Ardecus");
        res.FriendsId = new Long[] {123L, 358L};
        return res;
    } //yep, like this
    //public static Panel GetPanel(String panelid) {
    //    Panel res = new Panel();
    //    res.Name = "KURSATCH";
    //    res.Private = false;
    //    return res;
    //}
    //public static Panel[] GetPanels(String userid) {
    //    Panel res = new Panel();
    //    res.Name = "KURSATCH";
    //    res.Private = false;
    //    return new Panel[]{res};
    //}
    public static Activity GetActivity(String activityid) {
        Activity res = new Activity();
        res.Name = "PIZDOSHIT'";
        res.Id = Long.parseLong(activityid);
        return res;
    }
    public static Activity[] GetActivities(String userid) {
        Activity res = new Activity();
        res.Name = "PIZDOSHIT'";
        res.UserId = Long.parseLong(userid);
        //res.Type = Type.Marker;
        return new Activity[]{res};
    }
    public static Check GetCheck(String checkid) {
        return new Check(1L);
    }
    public static Check[] GetChecks(String activityid) {
        return new Check[1];
    }
    public static Badge[] GetBadges() {
        return new Badge[] {new Badge("Trial", 10)};
    }

    //POST
    public static void PostAuth(Auth gotten) {}
    public static void PostUser(User user) {}
    //public static void PostPanel(Panel panel){}
    public static void PostActivity(Activity activity) {}
    public static void PostCheck(Check check) {}

    //PUT
    public static void PutUser(User user) {}
    //public static void PutPanel(Panel panel){}
    public static void PutActivity(Activity activity) {}

    //DELETE
    public static void DeleteUser(String userid) {}
    public static void DeleteActivity(String activityid) {}


}
