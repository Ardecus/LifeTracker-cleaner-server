package Controller;

import Model.*;
import com.google.gson.Gson;
import Service.Classes.HttpResponse;

import java.util.Base64;
import java.util.HashMap;

public class MainController {
    static String auth;
    static HashMap<String, Auth> auths = new HashMap<>();

    static DatabaseController dc = DatabaseController.getInstance();

    static Gson g = new Gson();
    //GET
    public static HttpResponse GetUser(String[] params) { //params = {userid}
        try {
            User gotten = dc.GetUser(params[0]);
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
    public static HttpResponse GetActivity(String[] params) { //params = {userid???, activityid}
        try {
            Activity gotten = dc.GetActivity(params[1]);
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
    public static HttpResponse GetActivities(String[] params) { //params = {userid}
        try {
            Activity[] gotten = dc.GetActivities(params[0]);
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
    public static HttpResponse GetCheck(String[] params) { //params = {userid???, activityid???, checkid}
        try {
            Check gotten = dc.GetCheck(params[2]);
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
    public static HttpResponse GetChecks(String[] params) { //params = {userid???, activityid}
        try {
            Check[] gotten = dc.GetChecks(params[1]);
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

    public static HttpResponse GetFriends(String[] params) { //params = {userid}
        try {
            User gotten = dc.GetUser(params[0]);
            if (gotten == null) {
                return new HttpResponse(404);
            }
            String res = g.toJson(gotten.FriendsId);
            return new HttpResponse(200, res);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse GetSimilar(String[] params) {
        return new HttpResponse(400, "Not yet implemented :(");
    }

    //separate
    public static HttpResponse PublishActivity(String[] params) {
        return new HttpResponse(400, "Not yet implemented");
    }
    public static HttpResponse AuthoriseUser(String[] params) { //params = {body}
        try {
            Auth gotten = g.fromJson(params[0], Auth.class);
            if (gotten == null) {
                return new HttpResponse(400);
            }
            return new HttpResponse(gotten.equals(auths.get(Long.toString(gotten.Id))) ? 200 : 400);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }

    //POST
    public static HttpResponse PostUser(String[] params) { //params = {body}
        try {
            Auth gotten = g.fromJson(params[0], Auth.class);
            User user = new User(gotten.Name);
            gotten.Id = user.Id;
            dc.PostAuth(gotten);
            dc.PostUser(user);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(409);
        }
    }
    public static HttpResponse PostActivity(String[] params) { //params = {userid, body}
        try {
            Activity gotten = g.fromJson(params[1], Activity.class);
            gotten.UserId = Long.parseLong(params[0]); //?
            dc.PostActivity(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(409);
        }
    }
    public static HttpResponse PostCheck(String[] params) { //params = {userid???, activityid, body}
        try {
            Check gotten = g.fromJson(params[2], Check.class);
            gotten.ActivityId = Long.parseLong(params[1]); //?
            dc.PostCheck(gotten);
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
            User prev = dc.GetUser(gotten.Id.toString());
            if (gotten.FriendsId != prev.FriendsId) {
                int i = gotten.FriendsId.length - 1;
                while (i > prev.FriendsId.length - 1) {
                    dc.PostFriend(gotten.Id, gotten.FriendsId[i]);
                    i--;
                }
            }
            dc.PutUser(gotten);
            return new HttpResponse(201);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse PutActivity(String[] params) { //params = {userid, body}
        try {
            Activity gotten = g.fromJson(params[1], Activity.class);
            gotten.UserId = Long.parseLong(params[0]); //?
            dc.PutActivity(gotten);
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
            dc.DeleteUser(params[0]);
            return new HttpResponse(200);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }
    public static HttpResponse DeleteActivity(String[] params) { //params = {userid???, activityid
        try {
            dc.DeleteActivity(params[1]);
            return new HttpResponse(200);
        }
        catch(Exception ex)
        {
            return new HttpResponse(400);
        }
    }


    public static void GetAuths() {
        Auth[] as = dc.GetAuths();
        for (Auth a : as) {
            auths.put(Long.toString(a.Id), a);
        }
    }
    public static boolean CheckAuth(String a) {
        return auth.equals(auths.get(a).GetToken());
    }
    public static void SetAuth(String a) {
        auth = a;
    }
}
