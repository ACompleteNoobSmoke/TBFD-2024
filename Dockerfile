FROM openjdk:21

COPY target/TBFD-0.0.1-SNAPSHOT.jar /TBFD-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "TBFD-0.0.1-SNAPSHOT.jar"]