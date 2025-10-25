FROM openjdk:21-jdk-slim

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package -DskipTests && \
    apt-get remove -y maven && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

EXPOSE 8080

# Debug: Check if files exist
RUN ls -la target/classes/ || echo "target/classes does not exist"
RUN find target -name "*.class" || echo "No .class files found"

CMD ["java", "-cp", "target/classes", "nl.bsn.validator.BsnWebService"]