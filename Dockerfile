FROM maven:3.8.1-openjdk-17 AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests -X
RUN ls -l /app/target/

# Use the official OpenJDK image to run the app
FROM openjdk:17-slim
COPY --from=build /app/target/CheckIn-0.0.1-SNAPSHOT.war /usr/local/lib/checkin.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/checkin.war"]
