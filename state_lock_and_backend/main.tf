provider "aws" {
    region = "ap-south-1"
}

resource "aws_instance" "my-instance" {
    ami = "ami-0e35ddab05955cf57"
    instance_type = "value"
}