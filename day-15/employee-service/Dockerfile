FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /vinod/app/workspace

COPY ./target/employee-service-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT java -jar ./app.jar