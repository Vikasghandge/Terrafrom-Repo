resource "aws_instance" "test_server" {
  ami           = "ami-0ad21ae1d0696ad58"
  instance_type = "t2.micro"

  tags = {
    Name = "examplewebserverapp"
  }
}


resource "my_terraform_project" "main" {
  
  
}