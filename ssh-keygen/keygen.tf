provider "aws" {
    region = "ap-south-1"
  
}
provider "aws" {

  
}
#ec2 instance details
resource "aws_instance" "this" {
    ami = "ami-0ad21ae1d0696ad58"
    instance_type = "t2.micro"
    key_name = "aws_vikas"
    depends_on = [ aws_key_pair.aws_vikas ]
    
  }
  resource "aws_key_pair" "aws_vikas" {
    key_name = "aws_vikas"
    public_key = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIIdAJ4nddhoYZ9iTyzuSoQtgTbnd1UQ4hiUVYFlD0PRu ubuntu@ip-172-31-2-98"
    


    
  }