FROM openjdk:8
ADD target/sBootEtherDocker.jar sBootEtherDocker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sBootEtherDocker.jar"]
