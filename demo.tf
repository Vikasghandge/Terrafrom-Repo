provider "aws" {
    region = "ap-south-1"
}

provider "aws" {
    region = "us-east-1"
}

resource "aws_instance" "my_ec2" {
    ami = "value"
}