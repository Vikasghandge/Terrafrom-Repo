terraform {
  backend "s3" {
    bucket = "demo1122233buckettt3"
    key = "vikas/state.tfstate"
    region = "ap-south-1"
    dynamodb_table = "terraform-lock1"
    encrypt = true
  }
}