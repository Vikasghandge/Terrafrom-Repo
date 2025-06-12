module "tea1" {
    source = "./tea-module"
    ami = "ami-02521d90e7410d9f0"
    instance_type = "t2.micro"

}

module "tea2" {
    source = "./tea-module"
    ami = "ami-02521d90e7410d9f0"
    instance_type = "t2.large"
  
}