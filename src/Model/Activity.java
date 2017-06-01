package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Activity {
    public Long Id;
    //public Long PanelId;
    public Long UserId;
    public String Name;
    //public Type Type; //0-1-2 in db?
    //public int Min;
    //public int Max;

    public Activity() {
        Id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Activity(String name, Long userId) {//, int type){
        Id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        UserId = userId;
        Name = name;
        //Type = Model.Type.values()[type];
    }

    //public Activity(String name, int min, int max){
    //    Id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    //    PanelId = 1L;
    //    Name = name;
    //    Type = Model.Type.Metric;
    //    Min = min;
    //    Max = max;
    //}
}

