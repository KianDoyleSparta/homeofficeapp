# Running Jenkins for CICD

Jenkins requires a number secrets and configurations to function these include:

ssh key for accessing aws instance 
known hosts file should be automatically generated in the same space , if not use your known hosts file from your .ssh folder manually connect to ensure ip is there
application.properties containing secrets for accessing the db and connection string
public ip of the aws instance , along with the connection string
private ip of the aws instance


Jenkins configuraion requires the following : 