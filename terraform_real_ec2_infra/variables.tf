variable "aws_region" {
  description = "AWS region to deploy the instance"
  type        = string
  default     = "ap-south-1"
}

variable "ami_id" {
  description = "AMI ID"
  type        = string
}

variable "instance_type" {
  description = "Instance type"
  type        = string
  default     = "t2.micro"
}

variable "subnet_id" {
  description = "Subnet ID"
  type        = string
}

variable "security_group_id" {
  description = "Security Group ID"
  type        = string
}

variable "name_prefix" {
  description = "Prefix for instance names"
  type        = string
  default     = "Terraform_test"
}

variable "instance_count" {
  description = "Number of instances to launch"
  type        = number
  default     = 1
}
