#!/bin/bash
echo "Starting ..." >> logs/pm-processor.log
exec $JAVA_HOME/bin/java $1 -jar target/pm-processor-1.0-SNAPSHOT-jar-with-dependencies.jar $2 $3