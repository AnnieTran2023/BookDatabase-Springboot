# Use the official OpenJDK image as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the host machine to the container
COPY target/bookdatabase-0.0.1-SNAPSHOT.jar /app/bookdatabase.jar

# Copy the keystore into the container
COPY anniekeystore.p12 /app/anniekeystore.p12

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "bookdatabase.jar"]
