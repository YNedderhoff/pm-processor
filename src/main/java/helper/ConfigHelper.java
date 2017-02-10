package helper;

import domain.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class ConfigHelper {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ConfigHelper.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Config getConfig(String configJsonPath) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(new File(configJsonPath), Config.class);
        } catch (IOException e) {
            LOG.error("Something went wrong while reading the config.json: " + e);
            throw e;
        }

    }
}
