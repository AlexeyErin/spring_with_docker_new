FROM adoptopenjdk/openjdk17:alphine-jre
ARG JAR_FILE=out/artifacts/demo_jar/demo.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]