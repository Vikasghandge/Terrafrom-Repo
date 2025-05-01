module "eks" {
    source = "terraform-aws-modules/eks/aws"
    version = "19.15.1"


    cluster_name = local.name
    cluster_endpoint_public_access = true

    cluster_addons = {
        coredns = {
            most_recent = true 
        }
        kube_proxy = {
            most_recent = true 
        }
        vpc-cni = {
            most_recent = true 
        }
    }  
vpc_id = module.vpc.vpc.vpc_id
subnet_ids = module.vpc.private_subnets
control_plane_subnet_ids = module.vpc.intra_subnets


# EKS MANAGED NODE GROUPS(S)
eks_managed_node_group_defaults = {
    ami_type = "AZ2.x86_64"
    instance_type = ["m5.large"]

    attach_cluster_primary_security_groups = true 
}

eks_managed_node_groups = {
    cluster-wg = {
        min_size = 1
        max_size = 2
        desired_size = 1

        instance_type = ["t3.large"]
        capacity_type = "SPOT"

        tags = {
            ExtraTag = "helloWorld"
        }
        }
    }
tags = local.tags
}






}

