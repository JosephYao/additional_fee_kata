import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestAdditionalFeePeriod {

    @Test
    public void not_in_period() {
        AdditionalFeePeriod period = new AdditionalFeePeriod(LocalTime.of(0, 0), LocalTime.of(0, 0));
        Runnable ifFalse = mock(Runnable.class);

        period.contains(LocalDateTime.of(2016, 4, 24, 19, 1), ifFalse);

        verify(ifFalse).run();
    }
}
