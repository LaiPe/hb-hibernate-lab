FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/api-consumer-1.0-SNAPSHOT.jar consumer.jar
ENTRYPOINT [ "java", "-jar", "consumer.jar" ]

#  java -jar consumer.jar
