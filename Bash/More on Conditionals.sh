# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---more-on-conditionals

read x
read y
read z
if [ $x -eq $y ]
then 
    if [ $x -eq $z ]
    then
        echo EQUILATERAL
    else
        echo ISOSCELES
    fi
elif [ $x -eq $z ]
then
    echo ISOSCELES
eilf [ $y -eq $z ]
    echo ISOSCELES
else
    echo SCALENE
fi