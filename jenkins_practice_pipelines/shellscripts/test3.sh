#!/bin/bash
BUCKET_NAME="your-s3-bucket"
FILE_PATH="/path/to/your/file.txt"

aws s3 cp "$FILE_PATH" "s3://$BUCKET_NAME/"
echo "File uploaded to $BUCKET_NAME."
