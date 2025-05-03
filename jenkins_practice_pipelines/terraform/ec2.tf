provider "aws" {
    region = "ap-south-1"
}

# Get latest ubuntu AMI
data "aws_ami" "ubu"