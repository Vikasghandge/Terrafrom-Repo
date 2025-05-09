provider "aws" {
    region = "ap-south-1"
}

resource "aws_instance" "my-instance" {
    ami = "ami-0e35ddab05955cf57"
    instance_type = "t2.small"
    key_name = "vikas.key"
}

resource "aws_s3_bucket" "my_bucket" {
    bucket = "demo1122233bucket"

}

resource "aws_dynamodb_table" "terraform_lock" {
    name = "terraform-lock"
    billing_mode = "PAY-PER"
    
}
