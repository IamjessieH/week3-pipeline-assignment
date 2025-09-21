FROM openjdk:21-jdk-slim

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update
RUN apt-get install -y maven
RUN mvn clean package

EXPOSE 8080
CMD ["tail", "-f", "/dev/null"]


# empty trigger new pipeline