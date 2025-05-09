# shell script for to take automated backup of my file for 30 days and older than 30days it will delete automatically.

#!/bin/bash

SOURCE_DIR= /home/ubuntu  # source directory 
DEST_DIR= /tmp/backup_dir  # destination dir to backup
DATE=(date +"%d-%m-%d%-%H-%M-%S")  #date
DAYS_TO_KEEP= 30  # days to keep backups
BACKUP_NAME= "backup_*$DEST_DIR.tar.gz  

mkdir -p "$DEST_DIR"  

tar -cvf "$DEST_DIR/$BACKUP_NAME" -C "$SOURCE_DIR"

find $DEST_DIR -type f -name "backup_*.tar.gz" -mtime +DAYS_TO_KEEP -delete

echo "backup has taken sucessfully: $BACKUP_NAME"




