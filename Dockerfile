FROM ubuntu:16.04
ENV LANG ru_RU.UTF-8
RUN apt-get update && \
    apt-get install -y locales language-pack-ru && \
    locale-gen ru_RU.UTF-8 && \
    update-locale LANG=ru_RU.UTF-8 LC_ALL=ru_RU.UTF-8
ENV LANGUAGE ru_RU.UTF-8
ENV LC_ALL ru_RU.UTF-8

# Установка Java
FROM openjdk:20
WORKDIR /demo
COPY build/libs/ /demo/
ENTRYPOINT ["java", "-jar", "demo.jar"]
