FROM alpine:3.14

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk11 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/* \
  && mkdir -p /home/groupdocs/app && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f
WORKDIR /home/groupdocs/app
RUN mkdir -p "/home/groupdocs/app/DocumentSamples" && mkdir -p "/home/groupdocs/app/Licenses"
COPY ./DocumentSamples /home/groupdocs/app/DocumentSamples
COPY ./Licenses /home/groupdocs/app/Licenses
ADD build/distributions/conversion-ktor-23.6.tar /home/groupdocs/app

EXPOSE 8080

ENTRYPOINT /home/groupdocs/app/conversion-ktor-23.6/bin/conversion-ktor /home/groupdocs/app/conversion-ktor-23.6