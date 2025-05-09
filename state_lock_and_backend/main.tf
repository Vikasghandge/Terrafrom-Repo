provider "aws" {
    region = "ap-south-1"
}

resource "aws_instance" "my-instance11" {
    ami = "ami-0e35ddab05955cf57"
    instance_type = "t2.micro"
    key_name = "vikas-key"
}

# resource "aws_s3_bucket" "my_buckett" {
#    bucket = "demo1122233buckettt345"

# }

resource "aws_dynamodb_table" "terraform_lock1" {
    name = "terraform-lock1"
    billing_mode = "PAY_PER_REQUEST"
    hash_key = "LockID"
    
    attribute {
      name = "LockID"
      type = "S"
    }
}
