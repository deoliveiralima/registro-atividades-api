FROM openjdk:8-jdk-alpine



WORKDIR "/usr/app/"

COPY ./target/*.jar app.jar

EXPOSE 8080

CMD [ "java", "-jar",  "/usr/app/app.jar"]
