.ˀ.x.Echo "Enter the number:"
read num

is_prime=true

if [ $num -le 1 ]; then
 is_prime=false
else
 for ((i=2;i*i<=num; i++)); do
  if [ $((num%i)) -eq 0 ]; then 
   is_prime=false
   break
  fi
 done
fi

if [ $is_prime = true ]; then
 echo "$num is a prime number."
else
 echo"$not a number"
fi
