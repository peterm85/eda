FROM openjdk:11.0.6-jre
MAINTAINER Pedro Miguel Rodriguez <petermichael85@gmail.com>
EXPOSE 8080
COPY target/booking-sv*.jar booking-sv.jar
ENTRYPOINT java -Dspring.profiles.active=docker -jar booking-sv.jar