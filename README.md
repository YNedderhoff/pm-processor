#Particular matter data processor
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/11b94263db8946869474e552a3db0ce5)](https://www.codacy.com/app/YNedderhoff/pm-processor?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=YNedderhoff/pm-processor&amp;utm_campaign=Badge_Grade)

The related DockerHub repository of this is https://hub.docker.com/r/ynedderhoff/pm-processor/

## Run

```
docker run -d -v /local/path/to/config.json:/code/config.json:/code/config.json -v //local/path/to/logs/:/code/logs/ ynedderhoff/pm-processor "-Dlog.level=<log-level>" "config.json" "<interval-in-minutes>"

```

## Access running docker container

```
docker exec -i -t <container-name> /bin/bash
```

## Stop running docker instances

```
docker stop $(docker ps -a -q)
```


