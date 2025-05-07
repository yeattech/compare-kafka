FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/consumer-1.2-SNAPSHOT.jar /app/consumer.jar

EXPOSE 8201

ENTRYPOINT ["java", "-jar", "/app/consumer.jar"]