provider "aws" {
    region = "ap-south-1"
}
resource "aws_instance" "my-ec2" {
    ami = "ami-0dee22c13ea7a9a67"
    instance_type = "t2.micro"
    
}
output "my_output" {
    value = aws_instance.my-ec2.id
  
}