# Use the official Ubuntu base image
FROM ubuntu:latest

# Install Nginx, zip, unzip, wget
RUN apt-get update -y && apt-get install nginx unzip


# Expose the web server port
EXPOSE 80

# Start Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
