FROM eclipse-temurin:21-jdk

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

CMD ["java", "-cp", "target/classes", "nl.bsn.validator.BsnWebService"]