provider "aws" { 
    region = "ap-south-1"
}

resource "aws_instance" "my-ec2" {
    ami = "value"
    instance_type = "t2.medium"
    key_name = "vikas.key"

    
}


##########

vpc - name 
pvt_subnet - 
pub_subnet -
pub_rt -
pvt_rt -
nat_ga