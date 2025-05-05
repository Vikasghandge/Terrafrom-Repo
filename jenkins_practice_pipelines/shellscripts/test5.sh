# shell script for to take automated backup of my file for 30 days and older than 30days it will delete automatically.

#!/bin/bash

SOURCE_DIR= /home/ubuntu  # source directory 
DEST_DIR= /tmp/backup_dir  # desti
DATE=(date +"%d-%m-%d%-%H-%M-%S")
DAYS_TO_KEEP= 30
BACKUP_NAME= "backup_*$DEST_DIR.tar.gz

