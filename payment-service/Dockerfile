FROM openjdk:17
LABEL authors="sandeepdash"

ENV PORT=9093
ARG JAR_FILE=build/libs/payment-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} dash12020/payment-service.jar

ENTRYPOINT ["java", "-jar", "/dash12020/payment-service.jar"]
HEALTHCHECK CMD curl --fail http://localhost:${PORT}/actuator/info || exit 1

EXPOSE ${PORT}