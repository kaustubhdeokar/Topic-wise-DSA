read x
$i = 1
$sum = 0
$temp = 0
while [ $i -le $x ]
do
	read temp
	sum = $(($sum + $temp))
done

printf "%.3f" (echo $(($sum/$x)) )

