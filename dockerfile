# Use the official Ubuntu base image
FROM ubuntu:latest

# Install Nginx, zip, unzip, wget
RUN apt-get update -y && apt-get install -y  nginx zip unzip wget 
RUN wget https://www.free-css.com/assets/files/free-css-templates/download/page296/oxer.zip
RUN unzip oxer.zip
#COPY oxer-html/* /var/www/html
COPY oxer-html/* /var/www/html/


#cp -rvf oxer-html/* /var/www/html/


# Expose the web server port
EXPOSE 80

# Start Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
