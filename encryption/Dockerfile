# Use a maintained, up-to-date JRE image
FROM eclipse-temurin:17-jre-alpine

# Run as non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set the working directory in the container
WORKDIR /app

# Copy the project's jar file into the container at /app
COPY target/encryption-0.0.1.jar /app/encryption.jar

# Switch to non-root user
USER appuser

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "encryption.jar"]

