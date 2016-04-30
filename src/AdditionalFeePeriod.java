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
        if (isSameDayContained(dateTime) || isOverDayContained(dateTime))
            ifTrue.run();
        else
            ifFalse.run();
    }

    private boolean isSameDayContained(LocalDateTime dateTime) {
        return isLaterThanOrEqualStart(dateTime) && isEarlierThanEnd(dateTime);
    }

    private boolean isOverDayContained(LocalDateTime dateTime) {
        return overDay && (isLaterThanOrEqualStart(dateTime) ||
                isEarlierThanEnd(dateTime));
    }

    private boolean isEarlierThanEnd(LocalDateTime dateTime) {
        return Duration.between(end, timeOf(dateTime)).isNegative();
    }

    private boolean isLaterThanOrEqualStart(LocalDateTime dateTime) {
        return !Duration.between(start, timeOf(dateTime)).isNegative();
    }

    private LocalTime timeOf(LocalDateTime dateTime) {
        return dateTime.toLocalTime();
    }
}
