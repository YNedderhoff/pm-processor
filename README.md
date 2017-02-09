# Build and run:

```
docker build -t ynedderhoff/pm-processor .
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


