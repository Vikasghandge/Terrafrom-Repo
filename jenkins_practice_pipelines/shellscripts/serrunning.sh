SERVICE="nginx"
if syatemctl is-active --quite $SERVICE: then
echo "$SERVICE is running"
else 
     echo "