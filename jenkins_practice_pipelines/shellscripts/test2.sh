SOURCE_DIR= "/home/ubuntu"
DEST_DIR= "/tmp/backup_dir"
DAYS_TO_KEEP=30
DATE =$(date +"%y-%m-%d-%H-%M-%S")
BACKUP_NAME= "$bakcup_$DATE.tar.gz"

mkidr -p $