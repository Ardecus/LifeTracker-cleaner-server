package Model;

import java.awt.*;

//NAWP
//it won't require a separate table in db, will it?
enum Type {Toggle, Marker, Metric};

public class Activity {
    public int Id;
    //public User User; //UserId in db?
    public ActivityPanel Panel;
    public String Name;
    public Type Type; //TypeId in db?
    public Color Color; //ewr.
    public char Icon; //some shit like ♥ ♦ ☼ ?
    public int Min;
    public int Max;

    /*
    public bool VkAutoShared;
    public bool FbAutoShared;
    public bool TwAutoShared;
    */
}
