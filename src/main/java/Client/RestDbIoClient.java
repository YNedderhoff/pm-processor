package Client;

import Domain.Config;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class RestDbIoClient {

    private static final Logger LOG = Logger.getLogger(RestDbIoClient.class.getName());

    public Optional<HttpResponse> getAll(Config config) {
        try {
            return Optional.of(Unirest.get(config.getFeinstaubDbUrl())
                    .header("x-apikey", config.getFeinstaubDbApiKey())
                    .header("cache-control", "no-cache")
                    .asString());
        } catch (UnirestException e) {
            LOG.warning("Error sending GET request to restdb.io: " + e);
            return Optional.empty();
        }
    }

    public Optional<HttpResponse> post(String body, Config config) {
        try {
            return Optional.of(Unirest.post(config.getFeinstaubDbUrl())
                    .header("x-apikey", config.getFeinstaubDbApiKey())
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .body(body)
                    .asString());
        } catch (UnirestException e) {
            LOG.warning("Error sending POST request to restdb.io: " + e);
            return Optional.empty();
        }
    }

    public Optional<HttpResponse> put(String body, Config config) {
        try {
            return Optional.of(Unirest.put(config.getFeinstaubDbUrl())
                    .header("x-apikey", config.getFeinstaubDbApiKey())
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .body(body)
                    .asString());
        } catch (UnirestException e) {
            LOG.warning("Error sending PUT request to restdb.io: " + e);
            return Optional.empty();
        }
    }

    public Optional<HttpResponse> delete(Config config) {
        try {
            return Optional.of(Unirest.delete(config.getFeinstaubDbUrl())
                    .header("x-apikey", config.getFeinstaubDbApiKey())
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .asString());
        } catch (UnirestException e) {
            LOG.warning("Error sending DELETE request to restdb.io: " + e);
            return Optional.empty();
        }
    }
}
