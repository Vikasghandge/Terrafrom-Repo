provider "aws" {
    region = "ap-south-1"
}

# Get latest ubuntu AMI
data "aws_ami" "ubuntu" {
    most_recent = true
    owners = [ "099720109477" ]


filter {
  name = "name"
  values = [ "value" ]
}
}