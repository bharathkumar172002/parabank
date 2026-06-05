# Base image with JDK 21
FROM openjdk:21-jdk-slim

# Install Maven 3 and required tools
RUN apt-get update && apt-get install -y \
    maven \
    wget \
    unzip \
    curl \
    gnupg \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy project files
COPY . /app

# Install Google Chrome & ChromeDriver
RUN apt-get update && apt-get install -y google-chrome-stable \
    && DRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE) \
    && wget -q https://chromedriver.storage.googleapis.com/$DRIVER_VERSION/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip -d /usr/local/bin \
    && rm chromedriver_linux64.zip

# Run tests using Maven
CMD ["mvn", "test"]
