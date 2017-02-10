package domain;

/**
 * Created by ynedderhoff on 04.02.17.
 */
public class Config {

    private String feinstaubDbUrl;
    private String feinstaubDbApiKey;

    public String getFeinstaubDbUrl() {
        return feinstaubDbUrl;
    }

    public Config setFeinstaubDbUrl(String feinstaubDbUrl) {
        this.feinstaubDbUrl = feinstaubDbUrl;
        return this;
    }

    public String getFeinstaubDbApiKey() {
        return feinstaubDbApiKey;
    }

    public Config setFeinstaubDbApiKey(String feinstaubDbApiKey) {
        this.feinstaubDbApiKey = feinstaubDbApiKey;
        return this;
    }
}