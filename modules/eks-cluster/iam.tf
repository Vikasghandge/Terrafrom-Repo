resource "aws_iam_role" "eks_cluster" {
  name = "${var.cluster_name}-cluster-role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Principal = {
          Service = "eks.amazonaws.com"
        }
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "cluster_policies" {
  for_each = toset([
    "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy",
    "arn:aws:iam::aws:policy/AmazonEKSVPCResourceController"
  ])

  role       = aws_iam_role.eks_cluster.name
  policy_arn = each.value
}

# Then update your module block in main.tf:
module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "~> 20.0"

  # ... other config ...
  create_iam_role = false
  iam_role_arn    = aws_iam_role.eks_cluster.arn
  # ... rest of config ...
}