SOURCE_DIR = /home/ubuntu/
DEST_DIR = /tmp/backup_dir
BACKUP_NAME = "backup_$DATE.tar.gz"
DATE=$(date+"%y-%m-%d-%H-%M-%S")

tar -czf "$DEST_DIR/$BACKUP_NAME" "SOURCE_DIR"
echo "backup created: $BACKUP_NAME in $DEST_DIR"


* * * * *
*/5  1