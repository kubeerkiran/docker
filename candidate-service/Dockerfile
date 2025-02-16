FROM gradle:jdk17-graal-noble AS BUILDER

WORKDIR /app

COPY src src
COPY build.gradle build.gradle

RUN gradle clean build

FROM bellsoft/liberica-openjdk-alpine:23.0.2

WORKDIR /usr/share/app

#COPY build/libs/*.jar app.jar
COPY --from=BUILDER /app/build/libs/*.jar candidate-service.jar

CMD ["java", "-jar", "candidate-service.jar"]