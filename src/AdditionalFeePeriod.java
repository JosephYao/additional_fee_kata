import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdditionalFeePeriod {
    public AdditionalFeePeriod(LocalTime start, LocalTime end) {
    }

    public void contains(LocalDateTime dateTime, Runnable ifTrue, Runnable ifFalse) {
        ifFalse.run();
    }
}
