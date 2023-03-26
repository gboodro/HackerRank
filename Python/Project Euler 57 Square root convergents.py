# https://www.hackerrank.com/contests/projecteuler/challenges/euler057

import math

n = int(raw_input())
num = 1
den = 1
it = 0
for i in xrange(0, n+1):
    if math.floor(math.log10(num)) > math.floor(math.log10(den)):
        print(it)
    it += 1
    nnum = 2*den + num
    nden = den + num
    num = nnum
    den = nden
        