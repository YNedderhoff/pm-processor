package Helper;

import Domain.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class ConfigHelper {
    private static final Logger LOG = Logger.getLogger(ConfigHelper.class.getName());

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Config getConfig(String configJsonPath) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(new File(configJsonPath), Config.class);
        } catch (IOException e) {
            LOG.severe("Something went wrong while reading the config.json.");
            throw e;
        }

    }
}
