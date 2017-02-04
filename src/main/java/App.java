import Client.RestDbIoClient;
import Domain.Config;
import Helper.ConfigHelper;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());

    private static final RestDbIoClient REST_DB_IO_CLIENT = new RestDbIoClient();
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws IOException, UnirestException {
        String configJsonPath = args[0];
        int periodBetweenExecutions = Integer.parseInt(args[1]);
        run(configJsonPath, periodBetweenExecutions);
    }

    private static void run(String configJsonPath, int periodBetweenExecutions) throws IOException {
        final Config config = ConfigHelper.getConfig(configJsonPath);
        executor.scheduleAtFixedRate(() -> getAll(config), 0, periodBetweenExecutions, TimeUnit.MINUTES);
    }

    private static void getAll(Config config) {
        LOG.info("Sending GET request");
        REST_DB_IO_CLIENT.getAll(config)
                .ifPresent(r -> System.out.println(r.getBody()));
    }
}