#
# Build stage
#
FROM gradle:jdk17-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
ARG DB_PASSWORD
ARG DB_URL
ARG DB_USER
RUN gradle build --no-daemon

LABEL org.name="Darian W und Pilipp S"

#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/PutzPlaner-0.0.1-SNAPSHOT.jar app.jar
ENV DB_PASSWORD=${DB_PASSWORD}
ENV DB_URL=${DB_URL}
ENV DB_USER=${DB_USER}
ENTRYPOINT ["java","-jar","/app.jar"]
