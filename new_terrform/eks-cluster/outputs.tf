# output "cluster_name" {
#   value = module.eks.cluster_name
# }

# output "kubeconfig" {
#   value = module.eks.kubeconfig
# }

# output "cluster_endpoint" {
#   value = module.eks.cluster_endpoint
# }

output "cluster_name" {
  value = module.eks.cluster_name
}

output "cluster_endpoint" {
  value = module.eks.cluster_endpoint
}

output "cluster_certificate_authority_data" {
  value = module.eks.cluster_certificate_authority_data
}
