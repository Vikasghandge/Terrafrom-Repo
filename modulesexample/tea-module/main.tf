resource "aws_insatnce" "tea" {
    ami = var.ami
    instance_type = var.instance_type

}