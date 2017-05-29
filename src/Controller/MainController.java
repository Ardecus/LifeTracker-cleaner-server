package Controller;

import Service.HttpResponse;

public class MainController {
    //GET
    public static HttpResponse GetUser(String[] params) { //params = {userid}
        try {
            String res = DatabaseController.GetUser(params[0]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetPanel(String[] params) { //params = { userid???, panelid}
        try {
            String res = DatabaseController.GetPanel(params[1]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetPanels(String[] params) { //params = {userid}
        try {
            String res = DatabaseController.GetPanels(params[0]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetActivity(String[] params) { //params = {userid???, panelid???, activityid}
        try {
            String res = DatabaseController.GetActivity(params[2]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetActivities(String[] params) { //params = {userid???, panelid}
        try {
            String res = DatabaseController.GetActivities(params[1]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetCheck(String[] params) { //params = {userid???, panelid???, activityid???, checkid}
        try {
            String res = DatabaseController.GetCheck(params[3]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetChecks(String[] params) { //params = {userid???, panelid???, activityid}
        try {
            String res = DatabaseController.GetChecks(params[2]);
            if (res.length() == 0) {
                return new HttpResponse(404);
            }
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
    public static HttpResponse PostUser(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse PostPanel(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse PostActivity(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse PostCheck(String[] params) {return new HttpResponse(400, "ohfuck");}

    //PUT
    public static HttpResponse PutUser(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse PutPanel(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse PutActivity(String[] params) {return new HttpResponse(400, "ohfuck");}

    //DELETE
    public static HttpResponse DeleteUser(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse DeletePanel(String[] params) {return new HttpResponse(400, "ohfuck");}
    public static HttpResponse DeleteActivity(String[] params) {return new HttpResponse(400, "ohfuck");}
}
