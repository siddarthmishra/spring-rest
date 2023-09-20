FROM tomcat:8.5-jdk8-temurin-focal

RUN apt-get -y update

RUN apt-get -y install maven

RUN apt-get -y clean

RUN mkdir /opt/02-spring-rest-demo

COPY . /opt/02-spring-rest-demo/

WORKDIR /opt/02-spring-rest-demo

RUN mvn clean install

RUN cp target/spring-rest-demo.war /usr/local/tomcat/webapps

EXPOSE 8080
