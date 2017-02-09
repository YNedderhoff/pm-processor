The related DockerHub repository of this is https://hub.docker.com/r/ynedderhoff/pm-processor/

# Build and run:

```
docker run -d -v /local/path/to/config.json:/code/config.json:/code/config.json -v //local/path/to/logs/:/code/logs/ ynedderhoff/pm-processor "-Dlog.level=<log-level>" "config.json" "<interval-in-minutes>"

```

# Access running docker container:

```
docker exec -i -t <container-name> /bin/bash
```

# Stop running docker instances:

```
docker stop $(docker ps -a -q)
```


