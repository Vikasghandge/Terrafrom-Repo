terraform {
  backend "s3" {
    bucket = "demo1122233bucket"
    key = "terraform/state.tfstate"
    
  }
}