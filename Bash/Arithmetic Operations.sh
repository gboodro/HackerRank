# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---arithmetic-operations

read exp
printf "%.3f\n" $(echo "scale=10;$exp" | bc)