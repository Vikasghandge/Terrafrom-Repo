FROM ubuntu:lastest
RUN apt-get update -y && apt-get install apache2 zip unzip wget
WORKDIR /var/www/html
RUN wget https://www.free-css.com/assets/files/free-css-templates/download/page296/oxer.zip
RUN unzip oxer.zip
RUN cp -rvf . .
