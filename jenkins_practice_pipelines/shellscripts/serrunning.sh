SERVICE="nginx"

if systemctl is-active --quiet "$SERVICE"; then
    echo "$SERVICE is running"
else
    echo "$SERVICE is not running"
fi

################################################################################

SERVICE="nginx"

if systemctl is-active --quite "$SERVICE"; then 
    echo "$SERVICE is running"
else 
    echo "$SERVICE is not running"
fi

################################################################################.

SERVICE="nginx"

if systemctl is-active --quite "$SERIVICE" then;
    echo "$SERVICE is running"
else 
    echo "$SERVICE is not running"
fi       

######################################################

SERVICE='nginx'
 if systemctl is-active --quite '$SERVICE' then;
 echo "$SERVICE is running"
 else  
    echo "$SERVICE is not running"
fi




SERVICE="nginx"
if systemctl is-active --quite "$SERVICE" then;
