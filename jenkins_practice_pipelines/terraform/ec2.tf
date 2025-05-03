provider "aws" { 
    region = "ap-south-1"
}

resource "aws_instance" "my-ec2" {
    ami = "value"
    instance_initiated_shutdown_behavior = "value"
    
}