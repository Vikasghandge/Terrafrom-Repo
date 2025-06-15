provider "aws" {
  region = var.region
}

# Create Application Load Balancer
resource "aws_lb" "example" {
  name               = "blue-green-alb"
  load_balancer_type = "application"
  subnets            = var.public_subnets
}

# Target Group - blue
resource "aws_lb_target_group" "blue" {
  name     = "blue-target-group"
  port     = 80
  protocol = "HTTP"
  vpc_id   = var.vpc_id
}

# Target Group - green
resource "aws_lb_target_group" "green" {
  name     = "green-target-group"
  port     = 80
  protocol = "HTTP"
  vpc_id   = var.vpc_id
}

# Listener
resource "aws_lb_listener" "http" {
  load_balancer_arn = aws_lb.example.arn
  port              = 80
  protocol          = "HTTP"

  default_action {
    type            = "forward"
    target_group_arn = aws_lb_target_group.blue.arn
  }
}

# Auto Scaling Group - blue
resource "aws_launch_template" "blue" {
  name_prefix   = "blue-template"
  image_id      = var.ami_id
  instance_type = var.instance_type

  tag_specifications {
    resource_type = "instance"

    tags = {
      Name = "Blue-Server"
    }
  }
}

resource "aws_autoscaling_group" "blue" {
  max_size            = 1
  min_size            = 1
  desirable_capacity = 1
  launch_template {
    id      = aws_launch_template.blue.id
    version = "$Latest"
  }
  vpc_zone_identifier = var.public_subnets
  target_group_arns   = [aws_lb_target_group.blue.arn]
}

# Auto Scaling Group - green
resource "aws_launch_template" "green" {
  name_prefix   = "green-template"
  image_id      = var.ami_id
  instance_type = var.instance_type

  tag_specifications {
    resource_type = "instance"

    tags = {
      Name = "Green-Server"
    }
  }
}

resource "aws_autoscaling_group" "green" {
  max_size            = 1
  min_size            = 1
  desirable_capacity = 1
  launch_template {
    id      = aws_launch_template.green.id
    version = "$Latest"
  }
  vpc_zone_identifier = var.public_subnets
  target_group_arns   = [aws_lb_target_group.green.arn]
}

# Rule to forward to green instead
resource "aws_lb_listener_rule" "switch_to_green" {
  listener_arn = aws_lb_listener.http.arn
  priority     = 100

  action {
    type            = "forward"
    target_group_arn = aws_lb_target_group.green.arn
  }

  condition {
    path_pattern {
      values = ["/*"]
    }
  }
}
