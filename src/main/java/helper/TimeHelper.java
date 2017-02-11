package helper;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;

/**
 * Created by ynedderhoff on 11.02.17.
 */
public class TimeHelper {

    /**
     * Returns the time in nanoseconds (long) until the next rounded time.
     *
     * If e.g. the parameters are ZonedDateTime.now(), ChronoField.MINUTE_OF_HOUR, 15, it will return the time until
     * the next quarter hour.
     * @param input ZonedDateTime, the time from which the duration is calculated
     * @param roundTo the unit that is rounded, e.g. ChronoField.MINUTE_OF_HOUR
     * @param roundIncrement the number in the unit of roundTo we want the time to round to
     * @return the duration until the rounded time in long
     */
    public static long getDuration(ZonedDateTime input, TemporalField roundTo, int roundIncrement) {
        int field = input.get(roundTo);
        int r = field % roundIncrement;

        ZonedDateTime ceiling =
                input.plus(roundIncrement - r, roundTo.getBaseUnit())
                        .truncatedTo(roundTo.getBaseUnit());

        return Duration.between(input, ceiling).getNano();
    }
}
