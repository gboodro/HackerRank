# https://www.hackerrank.com/challenges/bash-tutorials-concatenate-an-array-with-itself

arr=(`cat`)
con=("${arr[@]}" "${arr[@]}" "${arr[@]}")
echo ${con[@]}
