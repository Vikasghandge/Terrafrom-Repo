resource "aws_vpc" "Terraform_vpc" {
    # // this will help to import vpc manually crated //
}

resource "aws_subnet" "Terraform_pub_sub" {
    vpc_id = "valuevpc-0ad71c754381424b0"
    
}