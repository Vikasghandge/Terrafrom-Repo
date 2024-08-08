provider "aws" {
  region = "ap-south-1"
}
resource "aws_s3_bucket" "my_bucket" {
  bucket  = "my-unique-bucket-name"
  tags    = {
	Name          = "MyS3Bucket"
	Environment    = "Production"
  }
}