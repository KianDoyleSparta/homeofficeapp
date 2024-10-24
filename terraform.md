
Remove-Item Env:AWS_ACCESS_KEY_ID
$env:AWS_PROFILE = "default"
aws sts get-caller-identity

Initialize Terraform: Open a terminal and navigate to the directory where your main.tf file is located. Run:

bash
Copy code
terraform init
Plan the Deployment: To see what resources will be created, run:

bash
Copy code
terraform plan
Apply the Configuration: To create the EC2 instance, run:

bash
Copy code
terraform apply