FROM alpine:3.14

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk11 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/* \
  && mkdir -p /home/groupdocs/app && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f
WORKDIR /home/groupdocs/app
COPY target/release/DocumentSamples /home/groupdocs/app
COPY target/release/Licenses /home/groupdocs/app
COPY target/release/conversion-spring-*.jar /home/groupdocs/app/app.jar

EXPOSE 8080

ENTRYPOINT java -jar /home/groupdocs/app/app.jar configuration.yml