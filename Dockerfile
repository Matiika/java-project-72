# Use the Gradle base image with JDK 21
FROM gradle:8.4.0-jdk21

# Set the working directory inside the container
WORKDIR /app

# Copy only the Gradle-related files first to cache dependencies
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Run dependency installation
RUN gradle build || return 0

# Copy the rest of the application code
COPY . .

# Run the Gradle build command to install the distribution
RUN gradle installDist

# Set the command to run the app
CMD ["./build/install/app/bin/app"]
