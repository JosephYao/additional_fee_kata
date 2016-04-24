import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdditionalFeePeriod {
    private final LocalTime start;
    private final LocalTime end;

    public AdditionalFeePeriod(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public void contains(LocalDateTime dateTime, Runnable ifTrue, Runnable ifFalse) {
        if (timeOfDate(dateTime).equals(start) || timeOfDate(dateTime).isBefore(end))
            ifTrue.run();
        else
            ifFalse.run();
    }

    private LocalTime timeOfDate(LocalDateTime dateTime) {
        return dateTime.toLocalTime();
    }
}
