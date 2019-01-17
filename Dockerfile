FROM openjdk:8u111-jdk-alpine

RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

RUN mkdir /scripts

RUN apk update
RUN apk upgrade
RUN apk add bash

VOLUME /tmp
ENV SPRING_PROFILE default

ADD /target/*.jar app.jar
ADD src/main/resources/scripts/setExpressCheckout.sh /scripts

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${SPRING_PROFILE}","-jar","/app.jar"]