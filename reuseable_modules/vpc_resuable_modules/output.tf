output "instance_public_ip" {
  description = "The public IP address of the EC2 instance"
  value       = aws_instance.example_instance.public_ip
}

output "vpc_id" {
  description = "The ID of the created VPC"
  value       = aws_vpc.example_vpc.id
}
