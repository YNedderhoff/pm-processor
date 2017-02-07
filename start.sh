#!/bin/bash
export JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/bin/java"
exec $JAVA_HOME/bin/java -jar myjar.jar $@