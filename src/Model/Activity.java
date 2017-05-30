package Model;

import java.awt.*;

//NAWP
//it won't require a separate table in db, will it?
enum Type {Toggle, Marker, Metric};

public class Activity {
    public int Id;
    public int PanelId;
    public String Name;
    public Type Type; //0-1-2 in db?
    public Color Color; //ewr.
    public int Min;
    public int Max;

    /*
    public bool FbAutoShared;
    public bool TwAutoShared;
    */
}
