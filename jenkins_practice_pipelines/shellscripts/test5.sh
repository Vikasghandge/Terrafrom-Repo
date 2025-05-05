# shell script for to take automated backup of my file for 30 days and older than 30days it will delete automatically.

#!/bin/bash

SOURCE_DIR= /home/ubuntu
DEST_DIR= /tmp/backup_dir
DATE=(date +"%d-%m-%d%-%H-%M-%S")
DAYS_TO_KEEP= 30
BACKUP_NAME=