FROM openjdk:17
LABEL authors="sandeepdash"

ENV PORT=9092
ARG JAR_FILE=build/libs/order-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} dash12020/order-service.jar

ENTRYPOINT ["java", "-jar", "/dash12020/order-service.jar"]
HEALTHCHECK CMD curl --fail http://localhost:${PORT}/actuator/info || exit 1

EXPOSE ${PORT}