SOURCE_DIR="/home/ubuntu"
DEST_DIR="/tmp/backup_dir"
DAYS_TO_KEEP= 30
DATE=(date "+%y-%m-%d-%H-%M-%S")
BACKUP_NAME="backup_*.tar.gz"

mkdir -p $DEST_DIR

tar -czf "$DEST_DIR/$BACKUP_NAME", -C "$SOURCE_DIR"

find $DEST_DIR -type -f -name "backup_*.tar.gz" -mtime +DAYS_TO_KEEP -delete


