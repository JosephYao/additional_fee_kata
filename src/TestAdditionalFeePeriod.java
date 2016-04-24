import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class TestAdditionalFeePeriod {

    private static final int NOT_CONTAINED_HOUR = 19;
    private static final int ANY_MINUTE = 1;
    private static final int START_HOUR = 3;
    private static final int END_HOUR = START_HOUR + 5;
    private static final int ZERO_MINUTE = 0;
    Runnable ifTrue = mock(Runnable.class);
    Runnable ifFalse = mock(Runnable.class);

    @Test
    public void not_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(NOT_CONTAINED_HOUR, ANY_MINUTE), ifTrue, ifFalse);

        verifyIfFalseRun();
    }

    @Test
    public void date_time_exactly_on_start_time() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(START_HOUR, ZERO_MINUTE), ifTrue, ifFalse);

        verifyIfTrueRun();
    }

    @Test
    public void date_time_later_than_start_time_but_early_than_end_time() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(START_HOUR + 1, ZERO_MINUTE), ifTrue, ifFalse);

        verifyIfTrueRun();
    }

    @Test
    public void date_time_early_than_start_time_not_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(START_HOUR - 1, ZERO_MINUTE), ifTrue, ifFalse);

        verifyIfFalseRun();
    }

    private AdditionalFeePeriod period(int startHour, int endHour) {
        return new AdditionalFeePeriod(LocalTime.of(startHour, ZERO_MINUTE), LocalTime.of(endHour, ZERO_MINUTE));
    }

    private LocalDateTime dateWithTime(int hour, int minute) {
        return LocalDateTime.of(2016, 4, 24, hour, minute);
    }

    private void verifyIfTrueRun() {
        verify(ifTrue).run();
        verify(ifFalse, never()).run();
    }

    private void verifyIfFalseRun() {
        verify(ifTrue, never()).run();
        verify(ifFalse).run();
    }

}
