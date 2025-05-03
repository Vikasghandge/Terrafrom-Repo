SOURCE_DIR= "/home/ubuntu"  #this is source dir will copy from this dir
DEST_DIR= "/tmp/backup_dir" #this is dest dir backup will be create here
DAYS_TO_KEEP=30  #duration of old backup files
DATE =$(date +"%y-%m-%d-%H-%M-%S") #date
BACKUP_NAME= "$bakcup_$DATE.tar.gz" #name of our 

mkidr -p $DEST_DIR

tar -cvf "$DEST_DIR/$BACKUP_NAME" -c "$SOURCE_DIR" # compressing file from source dir to dest dir using backup name

find $DEST_DIR -name "backup_*.tar.gz" -type f -mtime +DAYS_TO_KEEP -delete # search the file location of dest file which u want to delete backups


