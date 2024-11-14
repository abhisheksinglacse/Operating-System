while true; do
 echo "-------Menu-------"
 echo "1. List Files"
 echo "2. Process Status"
 echo "3. Display Date"
 echo "4. Number of Users"
 echo "5. Quit"

 read -p "Enter your choice: " choice
 
 case $choice in
  1)
    ls -l
    ;;
  2)
   ps aux
   ;;
  3)
   date
   ;;
  4)
   who | wc -l
   ;;
  5)
   echo "Goodbye!"
   break
   ;;
  *)
   echo "Invalid choice"
   ;;
 esac
  echo -n "Enter your preffered choice[1-5] Menu: "
 done
