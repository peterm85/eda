FROM openjdk:11.0.6-jre
MAINTAINER Pedro Miguel Rodriguez <petermichael85@gmail.com>
EXPOSE 8080
COPY target/user-sv*.jar user-sv.jar
ENTRYPOINT java -Dspring.profiles.active=docker -jar user-sv.jar