echo "Enter basic salary:"
read basic_salary
#allowances are 15% of the base sALARY
allowances=$((basic_salary*15/100))
gross_salary=$((basic_salary+allowances))
echo "Gross salary: $gross_salary"

