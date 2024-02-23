FROM openjdk:17
LABEL authors="sandeepdash"

ENV PORT=9000
ARG JAR_FILE=build/libs/ConfigServer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} dash12020/config-server.jar

ENTRYPOINT ["java", "-jar", "/dash12020/config-server.jar"]
HEALTHCHECK CMD curl --fail http://localhost:${PORT}/actuator/info || exit 1

EXPOSE ${PORT}