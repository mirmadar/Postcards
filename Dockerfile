FROM openjdk:20

WORKDIR /demo

COPY build/libs/ /demo/

ENTRYPOINT ["java", "-jar", "demo.jar"]
