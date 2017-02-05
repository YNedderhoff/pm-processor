# Get started with pm-processor

Run

`nohup java [-Dlog.level=<log.level>] -jar pm-processor-1.0-SNAPSHOT-jar-with-dependencies.jar "<path/to/config.json>" "<periodBetweenExecutionsInMinutes>" &
`

For Example:

`nohup java -Dlog.level=DEBUG -jar pm-processor-1.0-SNAPSHOT-jar-with-dependencies.jar "config.json" "15" &
`