provider "aws" {
  region = var.aws_region
}

resource "aws_instance" "myapp_updated_instance" {
  count                        = var.instance_count
  ami                          = var.ami_id
  instance_type                = var.instance_type
  subnet_id                    = var.subnet_id
  associate_public_ip_address  = true
  vpc_security_group_ids       = [var.security_group_id]

  tags = {
    Name = "${var.instance_name}-${count.index + 1}"
  }

  root_block_device {
    volume_size = 8
    volume_type = "gp3"
    iops        = 3000
    throughput  = 125
  }

  credit_specification {
    cpu_credits = "standard"
  }

  capacity_reservation_specification {
    capacity_reservation_preference = "open"
  }

  cpu_options {
    core_count       = 1
    threads_per_core = 1
  }

  enclave_options {
    enabled = false
  }

  maintenance_options {
    auto_recovery = "default"
  }

  metadata_options {
    http_endpoint               = "enabled"
    http_protocol_ipv6          = "disabled"
    http_put_response_hop_limit = 2
    http_tokens                 = "required"
    instance_metadata_tags      = "disabled"
  }

  private_dns_name_options {
    enable_resource_name_dns_a_record    = false
    enable_resource_name_dns_aaaa_record = false
    hostname_type                        = "ip-name"
  }
}