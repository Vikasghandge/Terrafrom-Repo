variable "region" {
  type = string
  description = "region calling"
}

variable "ami" {
  type = string
  description = "ami calling"
}

variable "instance_type" {
  type = string
  description = "server size calling"
}

variable "key_name" {
  type = string
  description = "key calling"
}

variable "tags" {
  type = map
  description = "calling the tag here"
}

variable "value" {
  type = string
  description = "output block calling"
}



