package client;

import domain.Config;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class RestDbIoClient {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RestDbIoClient.class);

    public Optional<HttpResponse> getAll(Config config) {
        try {
            return Optional.of(Unirest.get(config.getFeinstaubDbUrl())
                    .header("x-apikey", config.getFeinstaubDbApiKey())
                    .header("cache-control", "no-cache")
                    .asString());
        } catch (UnirestException e) {
            LOG.warn("Error sending GET request to restdb.io: " + e);
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
            LOG.warn("Error sending POST request to restdb.io: " + e);
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
            LOG.warn("Error sending PUT request to restdb.io: " + e);
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
            LOG.warn("Error sending DELETE request to restdb.io: " + e);
            return Optional.empty();
        }
    }
}
