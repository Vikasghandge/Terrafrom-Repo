resource "aws_instance" "test_server" {
     ami = ""
     instance_type = "t2.micro"
     tags = {
        name = "examlewebserverapp"
     }     }     
}