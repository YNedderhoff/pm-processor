#!/bin/bash
export JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/bin/java"
exec $JAVA_HOME $1 -jar target/pm-processor-1.0-SNAPSHOT-jar-with-dependencies.jar $2 $3