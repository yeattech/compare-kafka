FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/consumer-0.0.1-SNAPSHOT.jar /app/consumer.jar

EXPOSE 8100

ENTRYPOINT ["java", "-jar", "/app/consumer.jar"]