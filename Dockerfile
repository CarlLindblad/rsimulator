FROM maven:3.5-jdk-8-slim as maven

# Rsimulator
COPY pom.xml /rsimulator/
COPY src /rsimulator/src/
WORKDIR /rsimulator
RUN mvn -Dmaven.repo.local=repo.local package

FROM jetty:9.4.7-jre8 as jetty
COPY --from=maven /rsimulator/target/rsimulator*war $JETTY_BASE/webapps

# Rsimulator home directory is a volume, so it can be persisted and survive image upgrades
ENV RSIMULATOR_HOME /var/rsimulator_home
VOLUME $RSIMULATOR_HOME

ENTRYPOINT ["sh", "-c", "cd $JETTY_BASE; java -DrootPath=$RSIMULATOR_HOME -DuseRootRelativePath=true -jar $JETTY_HOME/start.jar"]
