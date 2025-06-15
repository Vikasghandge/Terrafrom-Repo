variable "region" {
  default = "us-east-1"
}

variable "vpc_id" {
  description = "VPC for EC2 and ALB"
}

variable "public_subnets" {
  description = "Public subnets for EC2 and ALB"
  type        = list(string)
}

variable "ami_id" {
  description = "AMI for EC2 instances"
}

variable "instance_type" {
  description = " EC2 Instance Type"
  default     = "t2.micro"
}

