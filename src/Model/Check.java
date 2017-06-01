package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Check {
    public Long Id;
    public Long ActivityId;
    public LocalDateTime Date; //fucking not sure about type
    //public LocalDateTime EndDate; //for toggles
    //public int Value; //for metrics

    public Check(Long activityId) {
        Id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        ActivityId = activityId;
        Date = LocalDateTime.now();
    }
}
