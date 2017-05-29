package Model;

import java.time.LocalDateTime;

public class ActivityMark {
    public int Id;
    public Activity Activity; //ActivityId in db
    public LocalDateTime Date; //fucking not sure about type
    public LocalDateTime EndDate; //for toggles
    public int Value; //for metrics
}
