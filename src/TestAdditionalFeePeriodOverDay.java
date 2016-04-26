import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.*;

public class TestAdditionalFeePeriodOverDay {
    
    @Test
    public void date_time_later_than_end_time_not_in_period() {
        AdditionalFeePeriod period = new AdditionalFeePeriod(LocalTime.of(20, 0), LocalTime.of(1, 0));
        Runnable ifTrue = mock(Runnable.class);
        Runnable ifFalse = mock(Runnable.class);

        period.contains(dateWithTime(2), ifTrue, ifFalse);

        verify(ifTrue, never()).run();
        verify(ifFalse).run();
    }

    private LocalDateTime dateWithTime(int hour) {
        return LocalDateTime.of(2016, 4, 24, hour, 0);
    }

}
