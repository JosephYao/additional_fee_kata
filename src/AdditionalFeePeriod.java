import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdditionalFeePeriod {
    private final LocalTime start;
    private final LocalTime end;
    private final boolean overDay;

    public AdditionalFeePeriod(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
        this.overDay = Duration.between(start, end).isNegative();
    }

    public void contains(LocalDateTime dateTime, Runnable ifTrue, Runnable ifFalse) {
        if (!overDay && isEarlierThanStart(dateTime) || isLaterThanOrEqualEnd(dateTime))
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
