SOURCE_DIR= "/home/ubuntu"  #this is source dir will copy from this dir
DEST_DIR= "/tmp/backup_dir" #this is dest dir backup will be create here
DAYS_TO_KEEP=30  #duration o
DATE =$(date +"%y-%m-%d-%H-%M-%S")
BACKUP_NAME= "$bakcup_$DATE.tar.gz"

mkidr -p $DEST_DIR

