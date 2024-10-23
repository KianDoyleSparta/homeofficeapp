provider "aws" {
  region = "eu-west-1"
}

resource "aws_instance" "my_app_instance" {
  ami           = "ami-0d64bb532e0502c46" # Ubuntu Server 20.04 LTS (HVM) - Change if needed
  instance_type = "t2.micro" # Change as needed
  key_name      = "AIprojectkeyjamescole" # Replace with your key pair name

  # Security group to allow SSH and HTTP access
  vpc_security_group_ids = [aws_security_group.my_app_sg.id]

  # User data script to install dependencies and clone the repository
  user_data = <<-EOF
              #!/bin/bash
              # Update and install necessary packages
              sudo apt-get update
              sudo apt-get install -y git wget

              # Install Temurin JDK (e.g., version 17)
              wget https://download.adoptium.net/v3/binary/39c3ff69-95c2-46bb-9275-85c42d4b22f7/7b33eab8-c3a6-49ed-89e2-5b3c597e8a4b/17/jdk/17.0.1+12/temurin-17.0.1+12-linux-x64.tar.gz
              sudo tar -xzf temurin-17.0.1+12-linux-x64.tar.gz -C /opt
              sudo update-alternatives --install /usr/bin/java java /opt/temurin-17.0.1+12/bin/java 1
              sudo update-alternatives --install /usr/bin/javac javac /opt/temurin-17.0.1+12/bin/javac 1
              echo "export JAVA_HOME=/opt/temurin-17.0.1+12" >> ~/.bashrc
              echo "export PATH=\$JAVA_HOME/bin:\$PATH" >> ~/.bashrc
              source ~/.bashrc

              # Clone the specific branch from GitHub
              cd /home/ubuntu
              git clone --branch cloud https://github.com/jamestcole/CICDjavadockerapp.git
              cd CICDjavadockerapp
              # Optionally, you can run Maven build or any other commands here
              # mvn clean install
              EOF

  tags = {
    Name = "MyAppInstance"
  }
}

resource "aws_security_group" "my_app_sg" {
  name        = "my_app_sg"
  description = "Allow SSH and HTTP traffic"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Allow SSH from anywhere, restrict as needed
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Allow HTTP from anywhere, restrict as needed
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1" # Allow all outbound traffic
    cidr_blocks = ["0.0.0.0/0"]
  }
}
