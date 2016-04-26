import org.junit.Test;

public class TestAdditionalFeePeriod {

    private static final int START_HOUR = 3;
    private static final int END_HOUR = START_HOUR + 5;
    private final AdditionalFeePeriodForTest period = new AdditionalFeePeriodForTest(START_HOUR, END_HOUR);

    @Test
    public void date_time_later_than_end_time_not_in_period() {
        period.containsWithIfTrueAndIfFalse(END_HOUR + 1);

        period.verifyIfFalseRun();
    }

    @Test
    public void date_time_exactly_on_start_time_in_period() {
        period.containsWithIfTrueAndIfFalse(START_HOUR);

        period.verifyIfTrueRun();
    }

    @Test
    public void date_time_later_than_start_time_but_earlier_than_end_time_in_period() {
        period.containsWithIfTrueAndIfFalse(START_HOUR + 1);

        period.verifyIfTrueRun();
    }

    @Test
    public void date_time_earlier_than_start_time_not_in_period() {
        period.containsWithIfTrueAndIfFalse(START_HOUR - 1);

        period.verifyIfFalseRun();
    }

    @Test
    public void date_time_exactly_on_end_time_not_in_period() {
        period.containsWithIfTrueAndIfFalse(END_HOUR);

        period.verifyIfFalseRun();
    }

}
