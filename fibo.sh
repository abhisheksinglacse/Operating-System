#!/bin/bash

fibonacci() {
    num=$1
    a=0
    b=1

    for (( i=0; i<num; i++ ))
    do
        echo -n "$a "
        fib=$((a + b))
        a=$b
        b=$fib
    done
    echo
}

read -p "Enter the number of terms: " n

if [ $n -le 0 ]; then
    echo "Please enter a positive integer."
else
    fibonacci $n
fi

