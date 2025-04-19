provider "aws" {
    region = "us-east-2"
}




module "rds" {
    source = "./modules/rds"
}