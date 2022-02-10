FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} consumidor-votacao.jar
ENTRYPOINT ["java","-jar","/consumidor-votacao.jar"]