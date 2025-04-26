
provider "aws" {
  region = var.region
}

module "vpc" {
  source               = "./modules/vpc"
  vpc_name             = "my-vpc"
  vpc_cidr             = "10.0.0.0/16"
  public_subnet_name   = "pub-subnet"
  public_subnet_cidr   = "10.0.1.0/24"
  private_subnet_name  = "pvt-subnet"
  private_subnet_cidr  = "10.0.2.0/24"
  az                   = "ap-south-1a"
  igw_name             = "my-igw"
  nat_name             = "my-nat"
  ami                  = var.ami
}
