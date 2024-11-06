### this file is for example modules to reuse 

main.tf

```
provider "aws" {
  region = "ap-south-1"  # Set to ap-south-1 (Mumbai region)
}

resource "aws_instance" "example" {
  ami           = var.ami_value              # AMI ID from variables file
  instance_type = var.instance_type_value    # Instance type from variables file
  subnet_id     = var.subnet_id_value        # Subnet ID from variables file
}
```


variable.tf

```
variable "ami_value" {
  description = "AMI ID for the EC2 instance"
  default     = "ami-0dee22c13ea7a9a67"   # Use your specified AMI ID
}

variable "instance_type_value" {
  description = "Instance type for the EC2 instance"
  default     = "t2.micro"                # Use your specified instance type
}

variable "subnet_id_value" {
  description = "Subnet ID for the EC2 instance"
  default     = ""                        # Leave empty if you want Terraform to choose the default subnet, or specify a subnet ID in the ap-south-1 region
}
```

output.tf
```
output "public-ip-address" {
  value = aws_instance.example.public_ip
}
```



#### vpc and server creation using terraform vpc, subnet, routetable, internetgateway, elasticip, 

main.tf     ### vpc 

```
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
```


variable.tf     ## adding variables 

```
variable "vpc_cidr" {
  description = "CIDR block for the VPC"
  default     = "10.0.0.0/16"
}

variable "subnet_cidr" {
  description = "CIDR block for the public subnet"
  default     = "10.0.1.0/24"
}

variable "ami_value" {
  description = "AMI ID for the EC2 instance"
  default     = "ami-0dee22c13ea7a9a67"  # Your specified AMI ID
}

variable "instance_type_value" {
  description = "Instance type for the EC2 instance"
  default     = "t2.micro"
}

variable "key_name" {
  description = "Key pair name for SSH access"
  default     = "my-key-pair"  # Replace with your key pair name
}

```


output.tf     ## out put

```
output "instance_public_ip" {
  description = "The public IP address of the EC2 instance"
  value       = aws_instance.example_instance.public_ip
}

output "vpc_id" {
  description = "The ID of the created VPC"
  value       = aws_vpc.example_vpc.id
}
```

