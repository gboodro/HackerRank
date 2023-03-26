# https://www.hackerrank.com/challenges/bash-tutorials-remove-the-first-capital-letter-from-each-array-element

arr=(`cat`)
echo ${arr[@]/[A-Z]/.}