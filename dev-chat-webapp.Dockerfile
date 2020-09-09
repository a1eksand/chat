FROM openjdk:14-alpine
COPY webapp/target/chat-webapp-0.0.1-SNAPSHOT.jar app.jar
ENV JVM_OPTS=""
ENV APP_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JVM_OPTS -jar /app.jar $APP_OPTS"]
