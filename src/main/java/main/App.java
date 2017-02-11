package main;

import client.RestDbIoClient;
import com.mashape.unirest.http.exceptions.UnirestException;
import domain.Config;
import helper.ConfigHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static helper.TimeHelper.getTimeToWait;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class App {

    private static Logger LOG = LoggerFactory.getLogger(App.class);

    private static final RestDbIoClient REST_DB_IO_CLIENT = new RestDbIoClient();
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws IOException, UnirestException {
        String configJsonPath = args[0];
        int intervalInMinutes = Integer.parseInt(args[1]);
        run(configJsonPath, intervalInMinutes);
    }

    private static void run(String configJsonPath, int intervallInMinutes) throws IOException {
        final Config config = ConfigHelper.getConfig(configJsonPath);

        executor.scheduleAtFixedRate(
                () -> getAll(config),
                getTimeToWait(intervallInMinutes),
                intervallInMinutes,
                TimeUnit.MINUTES
        );
    }

    private static void getAll(Config config) {
        LOG.info("Sending GET request");
        REST_DB_IO_CLIENT.getAll(config)
                .ifPresent(r -> LOG.debug("Retrieved Response: " + r.getBody().toString()));
    }
}
