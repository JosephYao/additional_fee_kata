import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class AdditionalFeePeriodForTest extends AdditionalFeePeriod {

    Runnable ifTrue = mock(Runnable.class);
    Runnable ifFalse = mock(Runnable.class);

    public AdditionalFeePeriodForTest(int startHour, int endHour) {
        super(LocalTime.of(startHour, 0), LocalTime.of(endHour, 0));
    }

    public void containsWithIfTrueAndIfFalse(int hour) {
        contains(dateWithTime(hour), ifTrue, ifFalse);
    }

    private LocalDateTime dateWithTime(int hour) {
        return LocalDateTime.of(2016, 4, 24, hour, 0);
    }

    public void verifyIfTrueRun() {
        verify(ifTrue).run();
        verify(ifFalse, never()).run();
    }

    public void verifyIfFalseRun() {
        verify(ifTrue, never()).run();
        verify(ifFalse).run();
    }
}
