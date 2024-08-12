resource "aws_vpc" "prod_vpc" {
  cidr_block = "10.0.0.0/16"
  enable_dns_support = true  # Enable DNS support
  enable_dns_hostnames = true  # Enable DNS hostnames
  enable_classiclink = false
  instance_tenancy = "default"    
    
  tags = {
    Name = "prod-vpc"
  }
}
