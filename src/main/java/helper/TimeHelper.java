package helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * Created by ynedderhoff on 11.02.17.
 */
public class TimeHelper {

    private static Logger LOG = LoggerFactory.getLogger(TimeHelper.class);

    public static long getTimeToWait(int intervalInMinutes) {
        ZonedDateTime now = ZonedDateTime.now();
        long timeToWait = getDuration(now, ChronoField.MINUTE_OF_HOUR, intervalInMinutes);
        LOG.info("Waiting until " + simplifyZonedDateTime(now, timeToWait) +
                ". The following interval is " + intervalInMinutes + " minutes.");
        return timeToWait;
    }

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
    private static long getDuration(ZonedDateTime input, TemporalField roundTo, int roundIncrement) {
        int field = input.get(roundTo);
        int r = field % roundIncrement;

        ZonedDateTime ceiling =
                input.plus(roundIncrement - r, roundTo.getBaseUnit())
                        .truncatedTo(roundTo.getBaseUnit());

        return Duration.between(input, ceiling).getSeconds();
    }

    private static String simplifyZonedDateTime(ZonedDateTime now, long timeToWait) {
        return now
                .plusSeconds(timeToWait)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
