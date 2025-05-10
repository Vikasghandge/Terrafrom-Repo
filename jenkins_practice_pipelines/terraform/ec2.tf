

provider "aws" { 
    region = "ap-south-1"
}

resource "aws_instance" "my-instance" {
    ami = "*******************"
    instance_type = "value"
}