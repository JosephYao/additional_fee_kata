import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class TestAdditionalFeePeriod {

    private static final int START_HOUR = 3;
    private static final int END_HOUR = START_HOUR + 5;
    Runnable ifTrue = mock(Runnable.class);
    Runnable ifFalse = mock(Runnable.class);

    @Test
    public void date_time_later_than_end_time_not_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(END_HOUR + 1), ifTrue, ifFalse);

        verifyIfFalseRun();
    }

    @Test
    public void date_time_exactly_on_start_time_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(START_HOUR), ifTrue, ifFalse);

        verifyIfTrueRun();
    }

    @Test
    public void date_time_later_than_start_time_but_earlier_than_end_time_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(START_HOUR + 1), ifTrue, ifFalse);

        verifyIfTrueRun();
    }

    @Test
    public void date_time_earlier_than_start_time_not_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(START_HOUR - 1), ifTrue, ifFalse);

        verifyIfFalseRun();
    }

    @Test
    public void date_time_exactly_on_end_time_not_in_period() {
        period(START_HOUR, END_HOUR).contains(dateWithTime(END_HOUR), ifTrue, ifFalse);

        verifyIfFalseRun();
    }

    private AdditionalFeePeriod period(int startHour, int endHour) {
        return new AdditionalFeePeriod(LocalTime.of(startHour, 0), LocalTime.of(endHour, 0));
    }

    private LocalDateTime dateWithTime(int hour) {
        return LocalDateTime.of(2016, 4, 24, hour, 0);
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
