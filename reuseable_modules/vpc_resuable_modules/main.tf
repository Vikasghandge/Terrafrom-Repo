provider "aws" {
  region = "ap-south-1"  # Mumbai region
}

# Create a VPC
resource "aws_vpc" "example_vpc" {
  cidr_block = var.vpc_cidr
  tags = {
    Name = "ExampleVPC"
  }
}

# Create a public subnet
resource "aws_subnet" "example_subnet" {
  vpc_id            = aws_vpc.example_vpc.id
  cidr_block        = var.subnet_cidr
  map_public_ip_on_launch = true  # Automatically assign a public IP to instances in this subnet
  availability_zone = "ap-south-1a"

  tags = {
    Name = "ExamplePublicSubnet"
  }
}

# Create an Internet Gateway
resource "aws_internet_gateway" "example_igw" {
  vpc_id = aws_vpc.example_vpc.id

  tags = {
    Name = "ExampleInternetGateway"
  }
}

# Create a route table for the VPC and associate it with the subnet
resource "aws_route_table" "example_route_table" {
  vpc_id = aws_vpc.example_vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.example_igw.id
  }

  tags = {
    Name = "ExampleRouteTable"
  }
}

# Associate the route table with the subnet
resource "aws_route_table_association" "example_route_table_assoc" {
  subnet_id      = aws_subnet.example_subnet.id
  route_table_id = aws_route_table.example_route_table.id
}

# Create an EC2 instance in the public subnet
resource "aws_instance" "example_instance" {
  ami           = var.ami_value
  instance_type = var.instance_type_value
  subnet_id     = aws_subnet.example_subnet.id
  key_name      = var.key_name

  tags = {
    Name = "ExampleEC2Instance"
  }
}
