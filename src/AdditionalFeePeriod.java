import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdditionalFeePeriod {
    private final LocalTime start;

    public AdditionalFeePeriod(LocalTime start, LocalTime end) {
        this.start = start;
    }

    public void contains(LocalDateTime dateTime, Runnable ifTrue, Runnable ifFalse) {
        if (dateTime.toLocalTime().equals(start))
            ifTrue.run();
        else
            ifFalse.run();
    }
}
