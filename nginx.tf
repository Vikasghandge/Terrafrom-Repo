provider "aws" {
  region = "ap-south-1"  # Change this to your desired region
}

resource "aws_instance" "web" {
  ami           = "ami-0ad21ae1d0696ad58"  # Update this to the latest Ubuntu AMI
  instance_type = "t2.micro"

  key_name = "devops-key"  # Replace with your EC2 key pair

  user_data = <<-EOF
                #!/bin/bash
                apt update
                apt install -y nginx unzip

                # Download and unzip the template
                wget https://www.free-css.com/assets/files/free-css-templates/download/page296/healet.zip
                unzip healet.zip -d /var/www/html
                rm healet.zip

                # Adjust permissions
                chown -R www-data:www-data /var/www/html/healet
                EOF

  tags = {
    Name = "nginx-web-server"
  }

  # Optional: Attach a security group to allow HTTP/HTTPS access
  vpc_security_group_ids = [aws_security_group.web_sg.id]
}

resource "aws_security_group" "web_sg" {
  name        = "web_sg"
  description = "Allow inbound traffic for web server"

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
