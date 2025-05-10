provider "aws" {
  region = var.aws_region
}

module "ec2" {
  source            = "../../module/ec2-instance"
  ami_id            = var.ami_id
  instance_type     = var.instance_type
  subnet_id         = var.subnet_id
  security_group_id = var.security_group_id
  key_name          = var.key_name
  name_prefix       = var.name_prefix
  instance_count    = var.instance_count
}