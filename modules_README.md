### this file is for example modules to reuse 

main.tf

```
provider "aws" {
  region = "ap-south-1"  # Set to ap-south-1 (Mumbai region)
}

resource "aws_instance" "example" {
  ami           = var.ami_value              # AMI ID from variables file
  instance_type = var.instance_type_value    # Instance type from variables file
  subnet_id     = var.subnet_id_value        # Subnet ID from variables file
}
```


variable.tf

```
variable "ami_value" {
  description = "AMI ID for the EC2 instance"
  default     = "ami-0dee22c13ea7a9a67"   # Use your specified AMI ID
}

variable "instance_type_value" {
  description = "Instance type for the EC2 instance"
  default     = "t2.micro"                # Use your specified instance type
}

variable "subnet_id_value" {
  description = "Subnet ID for the EC2 instance"
  default     = ""                        # Leave empty if you want Terraform to choose the default subnet, or specify a subnet ID in the ap-south-1 region
}
```

output.tf
```
output "public-ip-address" {
  value = aws_instance.example.public_ip
}
```
