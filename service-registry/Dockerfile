FROM openjdk:17
LABEL authors="sandeepdash"

ENV PORT=8761
ARG JAR_FILE=build/libs/service-registry-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} dash12020/service-registry.jar

ENTRYPOINT ["java", "-jar", "/dash12020/service-registry.jar"]
HEALTHCHECK CMD curl --fail http://localhost:${PORT} || exit 1

EXPOSE ${PORT}