FROM alpine:edge
MAINTAINER zhaw.ch
RUN apk add --no-cache openjdk11
COPY target/GeniusGym-1.0-SNAPSHOT.jar \
  /home/
CMD ["java","-jar","/home/GeniusGym-1.0-SNAPSHOT.jar"]
