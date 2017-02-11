package main;

import client.RestDbIoClient;
import com.mashape.unirest.http.exceptions.UnirestException;
import domain.Config;
import helper.ConfigHelper;
import helper.TimeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class App {

    private static Logger LOG = LoggerFactory.getLogger(App.class);

    private static final RestDbIoClient REST_DB_IO_CLIENT = new RestDbIoClient();
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws IOException, UnirestException {
        String configJsonPath = args[0];
        int periodBetweenExecutionsInMinutes = Integer.parseInt(args[1]);
        run(configJsonPath, periodBetweenExecutionsInMinutes);
    }

    private static void run(String configJsonPath, int periodBetweenExecutionsInMinutes) throws IOException {
        final Config config = ConfigHelper.getConfig(configJsonPath);
        long timeToWait = TimeHelper
                .getDuration(ZonedDateTime.now(), ChronoField.MINUTE_OF_HOUR, periodBetweenExecutionsInMinutes);

        LOG.info("First request will be at " + ZonedDateTime.now().plusSeconds(timeToWait) +
                ". Another request is following every " + periodBetweenExecutionsInMinutes + " minutes.");

        executor.scheduleAtFixedRate(
                () -> getAll(config),
                timeToWait,
                periodBetweenExecutionsInMinutes,
                TimeUnit.MINUTES
        );
    }

    private static void getAll(Config config) {
        LOG.info("Sending GET request");
        REST_DB_IO_CLIENT.getAll(config)
                .ifPresent(r -> LOG.debug("Retrieved Response: " + r.getBody().toString()));
    }
}
