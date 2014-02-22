#!/bin/bash
logfile=/home/ubuntu/.x.log
exec >> $logfile 2>&1
echo "$(tput setaf 4)..............................$(tput sgr0)"
echo "$(tput setaf 4) AWS SUMNULU INIT SCRIPT START . Bu script rc.local den calısıyor! $(tput sgr0)"
#################################################################################
NEW_fstab_PATH="/home/ubuntu/aws/fstab.NEW"

EBS_VOLUME_ID='vol-XXXXXX'

EBS_VOLUME_DEV='/dev/sdp'
#################################################################################
export EC2_URL=https://ec2.us-east-1.amazonaws.com
export EC2_PRIVATE_KEY=/home/ubuntu/aws/pk-XXXXXXXXXXX.pem
export EC2_CERT=/home/ubuntu/aws/cert-XXXXXXXXXX.pem
export JAVA_HOME=/usr/lib/jvm/java-6-openjdk/

touch  /home/ubuntu/.x_START_RCLOCAL

EC2_INSTANCE_ID=$(ec2metadata --instance-id)

echo "instance id" $EC2_INSTANCE_ID
echo "adding persistance ebs volume (id="$EBS_VOLUME_ID"  , zone=us-east-1c)"

ATTACH_RESULT=$(ec2-attach-volume $EBS_VOLUME_ID -i $EC2_INSTANCE_ID -d $EBS_VOLUME_DEV)
if [[ "$ATTACH_RESULT" == ATTACHMENT* ]];
        then
                echo "$(tput setaf 2) Attachment Success! $(tput sgr0)"
                touch  /home/ubuntu/.x_success_RCLOCAL
                echo $ATTACH_RESULT  > /home/ubuntu/.x_success_RCLOCAL
                cp $NEW_fstab_PATH /etc/fstab 

		echo "sleeping for 10 seconds"
                sleep 10
		mount /dev/xvdp /media

		shutdown -r now
        else
                touch /home/ubuntu/.x_fail_RCLOCAL
                echo $ATTACH_RESULT  > /home/ubuntu/.x_fail_RCLOCAL
                echo "$(tput setaf 1) Attachment failed!$(tput sgr0) _$ATTACH_RESULT _"
                echo "Abort script!"
fi

echo "$(tput setaf 4)AWS SUMNULU INIT SCRIPT END$(tput sgr0)"
exit 0

