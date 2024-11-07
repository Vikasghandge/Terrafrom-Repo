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
