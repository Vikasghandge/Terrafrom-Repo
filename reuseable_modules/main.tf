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
    bucket = "bucccket2"
    key    = "path/to/your/statefile.tfstate"  # Specify a path inside the bucket for your state file
    region = "ap-south-1"                     # Replace with the AWS region of your bucket
    encrypt = true                             # Optional, but recommended for encryption at rest
  }
}

