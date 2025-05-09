provider "aws" {
    region = "ap-south-1"
    alias = "mumbai"
}

provider "aws" {
    region = "us-east-1"
    alias = "virginia"
}

resource "aws_instance" "my_ec2" {
    ami = "ami-0e35ddab05955cf57"
    instance_type = "t2.micro"
    key_name = "vikas.key"
}