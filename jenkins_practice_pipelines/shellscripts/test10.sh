
SOURCE_DIR="/home/ubuntu"   # source dir
DEST_DIR="/tmp/backup_dir"  # destination dir
DATE=(date +"%y-%m-%d-%H-%M-%S") # date and time
DAYS_TO_KEEP= 30 # days to keep your backup you want. 
BACKUP_NAME="backup_*.tar.gz" #  backup name

mkdir -p "$DEST_DIR"

tar -cvf "$DEST_DIR/$BACKUP_NAME" -C "$SOURCE_DIR"

find "DEST_DIR" -type f -name "backup_*.tar.gz" -mtime +DAYS_TO_KEEP -delete

echo "backup sucessfully"
