SOURCE_DIR ="/home/ubuntu"
DEST_DIR ="/tmp/bakup-dir"
DAYS_TO_KEEP =30
DATE =$(date +"%y-%m-%d-%H-%M-%S")
BACKUP_NAME="bakup_$DATE.tar.gz"

mkdir -p "$DEST_DIR"

tar -cvf "$DEST_DIR/$BAKUP_NAME" -c "SOURCE_DIR" .

# find "$DEST_DIR" -name "backup_*.tar.gz" -type f -mtime +$DAYS_TO_KEEP -delete
find "DEST_DIR" -name "backup_*.tar.gz" -type -