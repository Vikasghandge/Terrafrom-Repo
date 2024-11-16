FROM ubuntu:lastest
RUN apt-get update -y && apt-get install apache2 zip unzip wget
WORKDIR /var/www/html
RUN wget 