# Define a provider (this is just a placeholder, as we're not using any actual provider here)
provider "null" {}

# Define a local value with your name
locals {
  my_name = "Vikas"
}

# Output the value of the local variable
output "name_output" {
  value = local.my_name
}
