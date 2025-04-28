#!/bin/bash

# Configuration
SOURCE_DIR="/home/ubuntu/"      # Directory to back up (trailing slash for contents)
DEST_DIR="/tmp/backup_dir"      # Where to store backups
DAYS_TO_KEEP=30                 # Number of days to keep backups
DATE=$(date +"%Y-%m-%d-%H%M%S") # Timestamp format (no colons for filenames)
BACKUP_NAME="backup_$DATE.tar.gz"

# Create destination directory if missing
mkdir -p "$DEST_DIR"

# Create compressed backup (without parent folder paths)
tar -czf "$DEST_DIR/$BACKUP_NAME" -C "$SOURCE_DIR" .

# Delete backups older than $DAYS_TO_KEEP days
find "$DEST_DIR" -name "backup_*.tar.gz" -type f -mtime +$DAYS_TO_KEEP -delete

# Print status
echo "Backup created: $BACKUP_NAME"
echo "Deleted backups older than $DAYS_TO_KEEP days"