terraform {
  backend "s3" {
    bucket = ""
    key = "vikas/state.tfstate"
    region = "ap-south-1"
    dynamodb_table = "terraform-lock"
    encrypt = true
  }
}