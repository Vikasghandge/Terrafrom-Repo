provider "aws" {
  region = var.aws_region
}

resource "aws_instance" "Terraform_test" {
  count                       = var.instance_count
  ami                         = var.ami_id
  instance_type               = var.instance_type
  subnet_id                   = var.subnet_id
  associate_public_ip_address = true
  vpc_security_group_ids      = [var.security_group_id]
  key_name = var.

  tags = {
    Name = "${var.name_prefix}-${count.index}"
  }

  root_block_device {
    volume_size = 8
    volume_type = "gp3"
  }

  # cpu_options block removed to support t2.micro
}
