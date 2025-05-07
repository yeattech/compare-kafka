FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/producer-1.1-SNAPSHOT.jar /app/producer.jar

EXPOSE 8100

ENTRYPOINT ["java", "-jar", "/app/producer.jar"]