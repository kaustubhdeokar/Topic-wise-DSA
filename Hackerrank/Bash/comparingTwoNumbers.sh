#!/bin/bash
read x
read y
if [ $x -lt $y ]
then
echo "y is greater"
elif [ $x -gt $y ]
then
echo "x is greater"
else
echo "equal"
fi
