FROM java:8

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["mvn", "package"]

ADD start.sh /code/start.sh
ADD stop.sh /code/stop.sh

ENTRYPOINT ["/bin/bash","start.sh"]
CMD ["-Dlog.level=DEBUG" "config.json" "15"]
