#Provider for authentication
provider "aws" {
    region = var.region
}

# # Terraform for S3 Backend
terraform {
    backend "s3" {
    bucket = "terraform-state-bucket-cdec-b37"
    key    = "terraform.tfstate"
    region = "ap-south-1"
    dynamodb_table = "terraform_state_lock"
    }
}

