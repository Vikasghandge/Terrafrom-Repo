#!/bin/bash

# Define directories and backup name
SOURCE_DIR="/home/ubuntu/"    # (Keep the trailing slash if you want contents, not the folder itself)
DEST_DIR="/tmp/backup_dir"
DATE=$(date +"%Y-%m-%d-%H-%M-%S")  # Fixed syntax: Added space after `date` and used `%Y` for 4-digit year
BACKUP_NAME="backup_$DATE.tar.gz"

# Create destination directory if missing
mkdir -p "$DEST_DIR"

# Create compressed backup
tar -czf "$DEST_DIR/$BACKUP_NAME" -C "$SOURCE_DIR" .  # Corrected: Added `-C` to avoid full paths in archive

# Confirm completion
echo "Backup created: $BACKUP_NAME in $DEST_DIR"