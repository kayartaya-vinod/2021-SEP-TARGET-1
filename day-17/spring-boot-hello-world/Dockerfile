FROM adoptopenjdk/openjdk11:alpine-slim
WORKDIR /vinod/app/workspace
COPY ./target/spring-boot-hello-world-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT java -jar ./app.jar