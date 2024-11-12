provider "aws" {
  region = "ap-south-1"  # Set to ap-south-1 (Mumbai region)
}

resource "aws_instance" "example" {
  ami           = var.ami_value              # AMI ID from variables file
  instance_type = var.instance_type_value    # Instance type from variables file
  subnet_id     = var.subnet_id_value        # Subnet ID from variables file
}



