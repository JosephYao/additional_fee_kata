import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class TestAdditionalFeePeriod {

    private static final int NOT_CONTAINED_HOUR = 19;
    private static final int ANY_MINUTE = 1;
    private static final int START_HOUR = 0;
    private static final int START_MINUTE = 0;
    AdditionalFeePeriod period = new AdditionalFeePeriod(LocalTime.of(0, 0), LocalTime.of(5, 0));
    Runnable ifTrue = mock(Runnable.class);
    Runnable ifFalse = mock(Runnable.class);

    @Test
    public void not_in_period() {
        period.contains(dateWithTime(NOT_CONTAINED_HOUR, ANY_MINUTE), ifTrue, ifFalse);

        verify(ifTrue, never()).run();
        verify(ifFalse).run();
    }

    @Test
    public void date_time_exactly_on_start_time() {
        period.contains(dateWithTime(START_HOUR, START_MINUTE), ifTrue, ifFalse);

        verify(ifTrue).run();
        verify(ifFalse, never()).run();
    }

    private LocalDateTime dateWithTime(int hour, int minute) {
        return LocalDateTime.of(2016, 4, 24, hour, minute);
    }

}
