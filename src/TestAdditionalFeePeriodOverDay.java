import org.junit.Test;

public class TestAdditionalFeePeriodOverDay {

    private static final int START_HOUR = 20;
    private static final int END_HOUR = 2;

    AdditionalFeePeriodForTest period = new AdditionalFeePeriodForTest(START_HOUR, END_HOUR);

    @Test
    public void date_time_later_than_end_time_not_in_period() {
        period.containsWithIfTrueAndIfFalse(END_HOUR + 1);

        period.verifyIfFalseRun();
    }

    @Test
    public void date_time_earlier_than_end_time_and_later_than_start_time_in_period() {
        period.containsWithIfTrueAndIfFalse(END_HOUR - 1);

        period.verifyIfTrueRun();
    }

    @Test
    public void date_time_earlier_than_start_time_not_in_period() {
        period.containsWithIfTrueAndIfFalse(START_HOUR - 1);

        period.verifyIfFalseRun();
    }
    
    @Test
    public void date_time_later_than_start_time_and_in_previous_day() {
        period.containsWithIfTrueAndIfFalse(START_HOUR + 1);

        period.verifyIfTrueRun();
    }

}
