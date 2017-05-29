package Service;

import java.util.HashMap;

import static Controller.MainController.*;

public class UriTree {
    public static Node top;

    public static HashMap<String, Integer> RequestMethod = new HashMap<String, Integer>(){{
        put("GET",0);
        put("POST",1);
        put("PUT", 2);
        put("DELETE", 3);
    }};

    public UriTree() {
        top = new Node("", null);
        Node first = new Node("api", null);
        top.Subnodes.add(first);
        //user
        Node user = new Node("_userid", new ProcessRequest[]{
                (params) -> GetUser(params),
                (params) -> PostUser(params),
                (params) -> PutUser(params),
                (params) -> DeleteUser(params)
        });
        first.Subnodes.add(user);
        //panel
        Node panel = new Node("_panelid", new ProcessRequest[]{
                (params) -> GetPanel(params),
                (params) -> PostPanel(params),
                (params) -> PutPanel(params),
                (params) -> DeletePanel(params)
        });
        user.Subnodes.add(panel);
        //-
        user.Subnodes.add(new Node("panels", new ProcessRequest[]{
                (params) -> GetPanels(params)
                //null,
                //null,
                //null
        }));
        //activity
        Node activity = new Node("_activityid", new ProcessRequest[]{
                (params) -> GetActivity(params),
                (params) -> PostActivity(params),
                (params) -> PutActivity(params),
                (params) -> DeleteActivity(params)
        });
        panel.Subnodes.add(activity);
        //-
        panel.Subnodes.add(new Node("activities", new ProcessRequest[]{
                (params) -> GetActivities(params)
                //null,
                //null,
                //null
        }));
        //check
        Node check = new Node("_checkid", new ProcessRequest[]{
                (params) -> GetCheck(params),
                (params) -> PostCheck(params)
                //null,
                //null
        });
        activity.Subnodes.add(check);
        //-
        activity.Subnodes.add(new Node("checks", new ProcessRequest[]{
                (params) -> GetChecks(params)
                //null,
                //null,
                //null
        }));

        /*
        current version of a tree:
        .
        ____-userid
        ____________panels
        ____________-panelid
        _____________________activities
        _____________________-activityid
        _________________________________checks
        _________________________________-checkid

         */
    }
}
