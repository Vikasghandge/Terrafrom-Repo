

provider "aws" { 
    region = "ap-south-1"
}

resource "aws_instance" "my-instance" {
    ami = "*******************"
    instance_type = "t2.small"
    key_name = "vikas-key"
}

resource "" "name" {
}