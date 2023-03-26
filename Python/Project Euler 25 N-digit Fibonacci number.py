# https://www.hackerrank.com/contests/projecteuler/challenges/euler025

arr = []
a = 1
b = 1
ten = 1
term = 1
for i in xrange(5001):
    while a < ten:
        a, b = b, a+b
        term += 1
    arr.append(term)
    ten *= 10
    
t = int(raw_input())
for i in xrange(t):
    print arr[int(raw_input())-1]