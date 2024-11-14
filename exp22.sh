#!/bin/bash

# Function to calculate factorial
factorial() {
    num=$1
    fact=1
    
    while [ $num -gt 1 ]
    do
        fact=$((fact * num))
        num=$((num - 1))
    done
    
    echo $fact
}

# Read the number from the user
echo "Enter a number: "
read number

# Call the factorial function
result=$(factorial $number)

# Output the result
echo "Factorial of $number is: $result"

