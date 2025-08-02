import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private static final int GIGA_SECONDS = 1_000_000_000;
    private LocalDateTime futureMoment;
    
    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        futureMoment = moment.plusSeconds(GIGA_SECONDS);
    }

    public LocalDateTime getDateTime() {
        return futureMoment;
    }
}
