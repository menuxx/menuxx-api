FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER YinChangsheng "ychangsheng@gmail.com"
ENV PEFRESHED_AT 2017-02-20
VOLUME /tmp
ADD target/mall-server.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-server -Xms512m -Xmx512m -Dspring.profiles.active=development"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
EXPOSE 8080