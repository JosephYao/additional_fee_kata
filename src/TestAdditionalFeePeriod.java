import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class TestAdditionalFeePeriod {

    @Test
    public void not_in_period() {
        AdditionalFeePeriod period = new AdditionalFeePeriod(LocalTime.of(0, 0), LocalTime.of(5, 0));
        Runnable ifTrue = mock(Runnable.class);
        Runnable ifFalse = mock(Runnable.class);

        period.contains(LocalDateTime.of(2016, 4, 24, 19, 1), ifTrue, ifFalse);

        verify(ifTrue, never()).run();
        verify(ifFalse).run();
    }

//    @Test
//    public void date_time_exactly_on_start_time() {
//        AdditionalFeePeriod period = new AdditionalFeePeriod(LocalTime.of(0, 0), LocalTime.of(5, 0));
//        Runnable ifTrue = mock(Runnable.class);
//        Runnable ifFalse = mock(Runnable.class);
//
//        period.contains(LocalDateTime.of(2016, 4, 24, 0, 0), ifTrue, ifFalse);
//
//        verify(ifTrue).run();
//        verify(ifFalse, never()).run();
//    }
}
