terraform {
  backend "s3" {
    bucket = "demo1122233buckettt345"
    key = "vikas/state.tfstate"
    region = "ap-south-1"
    dynamodb_table = "terraform-lock"
    encrypt = true
  }
}