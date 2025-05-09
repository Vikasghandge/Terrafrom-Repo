output "instance_ids" {
  value = [for instance in aws_instance.Terraform_test : instance.id]
}

output "public_ips" {
  value = [for instance in aws_instance.Terraform_test : instance.public_ip]
}