package Controller;

import Model.*;
import com.google.gson.Gson;
import Service.HttpResponse;

public class MainController {
    static Gson g = new Gson();
    //GET
    public static HttpResponse GetUser(String[] params) { //params = {userid}
        try {
            User gotten = DatabaseController.GetUser(params[0]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetPanel(String[] params) { //params = { userid???, panelid}
        try {
            Panel gotten = DatabaseController.GetPanel(params[1]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetPanels(String[] params) { //params = {userid}
        try {
            Panel[] gotten = DatabaseController.GetPanels(params[0]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetActivity(String[] params) { //params = {userid???, panelid???, activityid}
        try {
            Activity gotten = DatabaseController.GetActivity(params[2]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetActivities(String[] params) { //params = {userid???, panelid}
        try {
            Activity[] gotten = DatabaseController.GetActivities(params[1]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetCheck(String[] params) { //params = {userid???, panelid???, activityid???, checkid}
        try {
            Check gotten = DatabaseController.GetCheck(params[3]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetChecks(String[] params) { //params = {userid???, panelid???, activityid}
        try {
            Check[] gotten = DatabaseController.GetChecks(params[2]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }

    //not done
    public static HttpResponse FindSimilar(String[] params) {
        return new HttpResponse(400, "ohfuck");
    }

    //POST
    public static HttpResponse PostUser(String[] params) { //params = {body}
        try {
            User gotten = g.fromJson(params[0], User.class);
            DatabaseController.PostUser(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(409);
        }
    }
    public static HttpResponse PostPanel(String[] params) { //params = {userid, body}
        try {
            Panel gotten = g.fromJson(params[1], Panel.class);
            gotten.UserId = Integer.parseInt(params[0]); //?
            DatabaseController.PostPanel(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(409);
        }
    }
    public static HttpResponse PostActivity(String[] params) { //params = {userid???, panelid, body}
        try {
            Activity gotten = g.fromJson(params[2], Activity.class);
            gotten.PanelId = Integer.parseInt(params[1]); //?
            DatabaseController.PostActivity(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(409);
        }
    }
    public static HttpResponse PostCheck(String[] params) { //params = {userid???, panelid???, activityid, body}
        try {
            Check gotten = g.fromJson(params[3], Check.class);
            gotten.ActivityId = Integer.parseInt(params[2]); //?
            DatabaseController.PostCheck(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(409);
        }
    }

    //PUT
    public static HttpResponse PutUser(String[] params) { //params = {body}
        try {
            User gotten = g.fromJson(params[0], User.class);
            DatabaseController.PutUser(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse PutPanel(String[] params) { //params = {userid, body}
        try {
            Panel gotten = g.fromJson(params[1], Panel.class);
            gotten.UserId = Integer.parseInt(params[0]); //?
            DatabaseController.PutPanel(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse PutActivity(String[] params) { //params = {userid???, panelid, body}
        try {
            Activity gotten = g.fromJson(params[2], Activity.class);
            gotten.PanelId = Integer.parseInt(params[1]); //?
            DatabaseController.PutActivity(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }

    //DELETE
    public static HttpResponse DeleteUser(String[] params) { //params = {userid}
        try {
            DatabaseController.DeleteUser(params[0]);
            return new HttpResponse(200);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse DeletePanel(String[] params) { //params = {userid???, panelid}
        try {
            DatabaseController.DeletePanel(params[1]);
            return new HttpResponse(200);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse DeleteActivity(String[] params) { //params = {userid???, panelid???, activityid
        try {
            DatabaseController.DeleteActivity(params[2]);
            return new HttpResponse(200);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
}
