import org.junit.Test;

public class TestAdditionalFeePeriodOverDay {

    private static final int START_HOUR = 20;
    private static final int END_HOUR = 2;

    @Test
    public void date_time_later_than_end_time_not_in_period() {
        AdditionalFeePeriodForTest period = new AdditionalFeePeriodForTest(START_HOUR, END_HOUR);

        period.containsWithIfTrueAndIfFalse(END_HOUR + 1);

        period.verifyIfFalseRun();
    }

}
