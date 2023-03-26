# https://www.hackerrank.com/challenges/bash-tutorials-filter-an-array-with-patterns

arr=(`cat`)
echo ${arr[@]/*[aA]*/}
