FROM openjdk:21-jdk-slim

LABEL maintainer="gmc.beto@gmail.com"

RUN mkdir -p /var/lib/task/logs \
    && chmod 766 -R /var/lib/task

WORKDIR /

EXPOSE 8080

ARG JAR_FILE

ADD ${JAR_FILE} app.jar

VOLUME /tmp

VOLUME /var/lib/task

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /app.jar