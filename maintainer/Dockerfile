FROM maven:3-eclipse-temurin-17-alpine AS build
COPY . /root
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
RUN mvn -T 1C -f /root/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17-alpine
COPY --from=build /root/target/maintainer-*.jar app.jar
EXPOSE 8081
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "app.jar"]
