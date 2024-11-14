echo "enter a number"
read n

if [ $((n%2))  -gt 0 ]; then
 echo "number is odd"
else 
 echo "number is even"
fi




