import java.time.Duration;
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
        if (isEarlierThanStart(dateTime) || isLaterThanOrEqualEnd(dateTime))
            ifFalse.run();
        else
            ifTrue.run();
    }

    private boolean isLaterThanOrEqualEnd(LocalDateTime dateTime) {
        return !Duration.between(end, timeOf(dateTime)).isNegative();
    }

    private boolean isEarlierThanStart(LocalDateTime dateTime) {
        return Duration.between(start, timeOf(dateTime)).isNegative();
    }

    private LocalTime timeOf(LocalDateTime dateTime) {
        return dateTime.toLocalTime();
    }
}
