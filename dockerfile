# FROM ubuntu:lastest
# RUN apt-get update -y && apt-get install apache2 zip unzip wget
# WORKDIR /var/www/html
# RUN wget https://www.free-css.com/assets/files/free-css-templates/download/page296/oxer.zip
# RUN unzip oxer.zip
# RUN cp -rvf . .
# EXPOSE 80
# CMD [ "apache2ctl", "-D", "FOREGROUND" ]


# Use the official Ubuntu base image
FROM ubuntu:latest

# Install Apache2, zip, unzip, and wget
RUN apt-get update -y && \
    apt-get install -y apache2 zip unzip wget && \
    apt-get clean

# Set the working directory
WORKDIR /var/www/html

# Download and extract the template
RUN wget https://www.free-css.com/assets/files/free-css-templates/download/page296/oxer.zip && \
    unzip oxer.zip -d oxer && \
    cp -rvf oxer/* . && \
    rm -rf oxer oxer.zip

# Expose the web server port
EXPOSE 80

# Start Apache in the foreground
CMD ["apache2ctl", "-D", "FOREGROUND"]
