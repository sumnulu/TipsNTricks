```bash
#!/bin/bash
logfile=/home/ubuntu/.x.log
exec >> $logfile 2>&1
echo "$(tput setaf 4)..............................$(tput sgr0)"
echo "$(tput setaf 4) AWS SUMNULU INIT SCRIPT START $(tput sgr0)"
#################################################################################
IP_ADDRESS="XXX.XXX.XXX.XXX"
#################################################################################
export EC2_URL=https://ec2.us-east-1.amazonaws.com
export EC2_PRIVATE_KEY=/home/ubuntu/aws/pk-xxxxxx.pem
export EC2_CERT=/home/ubuntu/aws/cert-xxxxxxx.pem
export JAVA_HOME=/usr/lib/jvm/java-6-openjdk/

touch  /home/ubuntu/.x_START_RCLOCAL

EC2_INSTANCE_ID=$(ec2metadata --instance-id)

echo "instance id" $EC2_INSTANCE_ID
echo "Associeting addresss" $IP_ADDRESS

ec2-associate-address $IP_ADDRESS -i $EC2_INSTANCE_ID

echo "$(tput setaf 4)AWS SUMNULU INIT SCRIPT END$(tput sgr0)"
exit 0


