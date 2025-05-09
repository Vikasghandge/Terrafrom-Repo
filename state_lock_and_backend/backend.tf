terraform {
  backend "s3" {
    bucket = "demo1122233bucket"
    key = "terraform/state.tfstate"
    region = "ap-south-1"
    dynamodb_table = "terraform-locks"
    encrypt = true
  }
}