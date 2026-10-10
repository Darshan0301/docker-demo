FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/docker-dem-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

#java jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]