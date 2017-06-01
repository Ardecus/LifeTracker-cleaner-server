package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    //idgaf about a smell of this
    public Long Id;
    public String Name;

    public int Level = 1;
    public int Experience = 0;
    public LocalDateTime[] Badges = new LocalDateTime[Badge.Badges.length];

    public Long[] FriendsId;

    public User(String name) {
        Id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        Name = name;
    }
}
