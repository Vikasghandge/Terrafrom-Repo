resource "aws_vpc" "main" {
 cidr_block = "10.0.0.0/16"
 
 tags = {
   Name = "Project VPC"
 }
}


resource "aws_project-vpc" "main_vpc" 
{ cidr_block = "10.0.0.0/16"

tags
  
}