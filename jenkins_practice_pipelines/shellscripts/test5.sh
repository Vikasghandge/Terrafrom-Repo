# shell script for to take automated backup of my file for 30 days and older than 30days it will delete automatically.

#!/bin/bash

SOURCE_DIR= /home/ubuntu
DEST_DIR= /tmp/bakcu
DATE=
DAYS_TO_KEEP=
BACKUP_NAME=