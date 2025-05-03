provider "aws" { 
    region = "ap-south-1"
}

resource "aws_inspector2_delegated_admin_account" "name" {
    account_id = "value"
    
}