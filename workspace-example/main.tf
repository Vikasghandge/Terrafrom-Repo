provider "aws" {
    region = "ap-south-1"
}

resource "aws_instance" "my-instance" {
    ami = "mi-0ad21ae1d0696ad58"
    instance_type = "value"
    
}