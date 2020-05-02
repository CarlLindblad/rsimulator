FROM maven:3.5-jdk-8-slim as maven

COPY pom.xml /workdir/
COPY src /workdir/src/
WORKDIR /workdir
RUN mvn -Dmaven.repo.local=repo.local package

FROM jetty:9.4.7-jre8 as jetty
COPY --from=maven /workdir/target/*war $JETTY_BASE/webapps

ENV IMAGE_HOME /var/image_home
VOLUME $IMAGE_HOME

ENTRYPOINT ["sh", "-c", "cd $JETTY_BASE; java -DrootPath=$IMAGE_HOME -DuseRootRelativePath=true -jar $JETTY_HOME/start.jar"]
