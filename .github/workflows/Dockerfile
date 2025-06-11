# Use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and source code from host into container
COPY pom.xml .                         # Copy POM
COPY src ./src                         # Copy source code

# Build the application using Maven
RUN mvn clean package -DskipTests      # Build without running tests

# -------------------------------------------------------------------

# Use a lightweight JDK image to run the app
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the built jar from the build image
COPY --from=build /app/target/*.jar app.jar

# Expose port (default for Spring Boot)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
