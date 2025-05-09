variable "ami_id" {}
variable "instance_type" {}
variable "subnet_id" {}
variable "security_group_id" {}
variable "key_name" {}
variable "instance_count" {
  default = 1
}
variable "name_prefix" {}