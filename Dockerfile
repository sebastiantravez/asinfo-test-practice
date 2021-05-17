FROM openjdk:11-jre
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
HEALTHCHECK --start-period=11s --interval=10s --timeout=5s --retries=3 CMD curl --silent --fail --request GET http://127.0.0.1:8080/actuator/health