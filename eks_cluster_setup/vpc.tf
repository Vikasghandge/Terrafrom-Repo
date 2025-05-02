module "vpc" {
  source = "terraform-aws-modules/vpc/aws"
  version = "~> 4.0"


  name = local.name
  cidr = local.vpc_cidr

  azs = local.azs
  private_subnets = local.private_subnets
  public_subnets = local.public_subnets
  infra_subnets = local.infra_subnets

  enable_nat_gateway = true 
  public_subnet_tags = {
    "kubernets.io/role/elb" = 1
  }

  private_subnet_tags = {
    "kubenets.io/role/internal-elb" = 1
  }
}