# THIS WORKS LOCALLY
#FROM openjdk:17
#COPY /target/AuthServerService-0.0.1-SNAPSHOT.jar AuthServerService-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "AuthServerService-0.0.1-SNAPSHOT.jar"]


FROM maven:3.8.1-openjdk-17-slim AS builder
WORKDIR /build
COPY pom.xml .
COPY src src/

# RUN mvn clean // To potentially emtpy a existing target folder
RUN mvn -f /build/pom.xml clean
# RUN mvn install -f /build/pom.xml
RUN mvn -f /build/pom.xml package


FROM openjdk:17
COPY --from=builder /build/target/AuthServerService-0.0.1-SNAPSHOT.jar ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "AuthServerService-0.0.1-SNAPSHOT.jar"]


#FROM maven:3.8.1-openjdk-17-slim AS builder
#WORKDIR /build
###COPY ./mvnw .
###COPY ./.mvn/ .mvn/
#COPY ./pom.xml .
#COPY ./src/ src/
#RUN mvn -f /build/pom.xml package
#
#
#FROM openjdk:17-alpine
#WORKDIR /backendimage
#
#COPY --from=builder /build/target/AuthServerService-0.0.1-SNAPSHOT.jar ./
#EXPOSE 8080
#CMD ["java", "-jar", "AuthServerService-0.0.1-SNAPSHOT.jar"]
#

#FROM java:8
#WORKDIR /
#ADD HelloWorld.jar HelloWorld.jar
#ADD /target/AuthServerService-0.0.1-SNAPSHOT.jar AuthServerService-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#CMD java - jar HelloWorld.jar
# MAYBE SLASH / ahead of jag file in ENTRYPOINT

#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ./target/AuthServerService-0.0.1-SNAPSHOT.jar AuthServerService-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "AuthServerService-0.0.1-SNAPSHOT.jar"]