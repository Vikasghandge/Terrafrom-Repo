
terraform {
  backend "s3" {
    bucket = "my-terraform-state-bucket123"
    key    = "vpc/terraform.tfstate"
    region = "ap-south-1"
  }
}
