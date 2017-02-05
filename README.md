# Get started with pm-processor

Run
```
mvn clean install
nohup java [-Dlog.level=<log.level>] -jar </path/to/jar-with-dependencies> "<path/to/config.json>" "<periodBetweenExecutionsInMinutes>" &
```

For Example:

`nohup java -Dlog.level=DEBUG -jar pm-processor-1.0-SNAPSHOT-jar-with-dependencies.jar "config.json" "15" &
`