#!/bin/bash

echo "Enter a string: "
read str

rev_str=$(echo $str | rev)

if [ "$str" == "$rev_str" ]; then
    echo "The string '$str' is a palindrome."
else
    echo "The string '$str' is not a palindrome."
fi

