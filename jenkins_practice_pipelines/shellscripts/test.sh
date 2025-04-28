SOURCE_DIR = /home/ubuntu/
DEST_DIR = /tmp/backup_dir
BACKUP_NAME = "backup_$DATE.tar.gz"
DATE=$(date+"%y-%m-%d-%H-%M-%S")

tar -czf "$DEST_DIR/$