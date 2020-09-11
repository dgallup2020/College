#/bin/bash

echo "Exit by typing ctrl-D"
#this is the eefault menulist here. This will repeat every time
PS3="Which file? "
select file in *
do
	if [ ! $file ]; then
	echo "REPLY = $REPLY"
	file=$REPLY
	else
	echo "file = $file"
	fi
done
echo $file
