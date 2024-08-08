# Configure the AWS provider
provider "aws" {
  region = "ap-south-1"  # AWS region where the S3 bucket will be created
}

# Define the S3 bucket resource
resource "aws_s3_bucket" "my_bucket" {
  bucket = "my-unique-bucket-name"  # Replace with a globally unique bucket name
  acl    = "private"  # Set bucket ACL to private by default

  tags = {
    Name        = "MyS3Bucket"
    Environment = "Production"
  }
}
