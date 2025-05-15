FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -P seeding

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/seeding.jar seeding.jar
ENTRYPOINT [ "java", "-jar", "seeding.jar"]

#  java -jar seeding.jar
