variable "aws_region" {
  description = "AWS region"
  type        = string
  default     = "ap-south-1"
}

variable "ami_id" {
  description = "AMI ID"
  type        = string
  default     = "ami-0e35ddab05955cf57"
}

variable "instance_type" {
  description = "EC2 instance type"
  type        = string
  default     = "t2.micro"
}

variable "instance_count" {
  description = "Number of EC2 instances"
  type        = number
  default     = 1
}

variable "instance_name" {
  description = "EC2 instance name prefix"
  type        = string
  default     = "Terraform_test"
}

variable "subnet_id" {
  description = "Subnet ID"
  type        = string
  default     = "subnet-0c0645d5bb4363e74"
}

variable "security_group_id" {
  description = "Security Group ID"
  type        = string
  default     = "sg-08cabcfd4b939f93f"
}














