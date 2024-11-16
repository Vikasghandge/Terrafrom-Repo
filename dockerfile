# Use the official Ubuntu base image
FROM ubuntu:latest

# Install Nginx, zip, unzip, wget
RUN apt-get update -y && \
    apt-get install -y nginx zip unzip wget && \

# Set the working directory for Nginx
WORKDIR /usr/share/nginx/html

# Download and extract the template
RUN wget https://www.free-css.com/assets/files/free-css-templates/download/page296/oxer.zip && \
    unzip oxer.zip 
    cp -rvf oxer/* . && \
    rm -rf oxer oxer.zip

# Expose the web server port
EXPOSE 80

# Start Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
