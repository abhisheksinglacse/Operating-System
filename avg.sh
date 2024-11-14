#!/bin/bash

read -p "Enter the number of elements (N): " N

sum=0

for (( i=1; i<=N; i++ ))
do
    read -p "Enter number $i: " num
    sum=$((sum + num))
done

average=$(echo "scale=2; $sum / $N" | bc)

echo "The average of $N numbers is: $average"

