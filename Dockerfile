FROM eclipse-temurin:21-jre-jammy

# Set working directory
WORKDIR /app

# Copy the compiled jar from the target directory
COPY target/*.jar app.jar

EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
