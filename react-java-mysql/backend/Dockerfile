FROM eclipse-temurin:11-jdk-jammy

WORKDIR /app
COPY ./target/Plants-0.0.1-SNAPSHOT.jar /app
COPY Group3KeyStore.jks /app

EXPOSE 8080
EXPOSE 5555

CMD ["java", "-jar", "Plants-0.0.1-SNAPSHOT.jar"]