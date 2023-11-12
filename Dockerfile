FROM gradle:8.4 AS build
LABEL authors="Mykhailo Chirozidi"
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle build

FROM openjdk:17-slim
EXPOSE $PORT:8080
RUN mkdir /server
COPY --from=build /app/build/libs/back-end-course-0.0.1-SNAPSHOT.jar /server/back-end-course-0.0.1-SNAPSHOT.jar
CMD ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/server/back-end-course-0.0.1-SNAPSHOT.jar"]
