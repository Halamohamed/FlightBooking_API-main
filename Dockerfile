#Use a lightweight JDK image
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean install

#
#Package Stage
#
FROM eclipse-temurin:17-jdk

# Copy Maven build output
COPY --from=build /target/*.jar FlightBooking_API-0.0.1-SNAPSHOT.jar

# Expose the port Spring Boot will run on
EXPOSE 8080

#Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]