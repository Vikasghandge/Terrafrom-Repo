provider "aws" {
  region = "ap-south-1"  # Set to ap-south-1 (Mumbai region)
}

resource "aws_instance" "example" {
  ami           = var.ami_value              # AMI ID from variables file
  instance_type = var.instance_type_value    # Instance type from variables file
  subnet_id     = var.subnet_id_value        # Subnet ID from variables file
}

terraform {
  backend "s3" {
    bucket = "bucccket2"                   # Your S3 bucket for Terraform state
    key    = "terraform/state/statefile.tfstate"  # Path inside the bucket for your state file
    region = "ap-south-1"                  # AWS region for the S3 bucket
    encrypt = true                         # Optional, enables encryption at rest for the state file
  }
}

