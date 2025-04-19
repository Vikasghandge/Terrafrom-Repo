terraform {
  required_version = ">= 1.0.0"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"  # Using the latest stable version
    }
  }
}

provider "aws" {
  region = var.region
}