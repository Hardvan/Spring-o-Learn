# Use the official Java image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/springolearn.jar /app/springolearn.jar

# Expose the port your app runs on
EXPOSE 8090

# Run the JAR file
CMD ["java", "-jar", "springolearn.jar"]
