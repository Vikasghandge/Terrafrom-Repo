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

