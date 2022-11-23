FROM openjdk:11-jre-slim

COPY build/libs/*.jar app.jar

ARG S3_ACCESS_KEY
ENV S3_ACCESS_KEY ${S3_ACCESS_KEY}

ARG S3_SECRET_KEY
ENV S3_SECRET_KEY ${S3_SECRET_KEY}

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
