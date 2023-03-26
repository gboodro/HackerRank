# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---compute-the-average

read n
s=0
for i in `seq 1 $n`
do
    read v
    s=$[$s+$v]
done
printf "%.3f\n" $(echo "scale=10;$s/$n" | bc)