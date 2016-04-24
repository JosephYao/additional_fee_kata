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
        if (timeOf(dateTime).equals(start) || timeOf(dateTime).isBefore(end) && timeOf(dateTime).isAfter(start))
            ifTrue.run();
        else
            ifFalse.run();
    }

    private LocalTime timeOf(LocalDateTime dateTime) {
        return dateTime.toLocalTime();
    }
}
