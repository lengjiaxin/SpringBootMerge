FROM frolvlad/alpine-oraclejdk8:slim

COPY target/coolcat-1.0.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]