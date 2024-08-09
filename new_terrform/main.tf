terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "5.61.0"
    }
  }
}

provider "aws" {
  # Configuration options
  region = var.region
}

##### Try to create one ubuntu server
resource "aws_instance" "this" {
  ami                     = var.ami
  instance_type           = var.instance_type
  key_name                = var.key_name

  tags = var.tags

}
