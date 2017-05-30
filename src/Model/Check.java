package Model;

import java.time.LocalDateTime;

public class Check {
    public int Id;
    public int ActivityId;
    public LocalDateTime Date; //fucking not sure about type
    public LocalDateTime EndDate; //for toggles
    public int Value; //for metrics
}
