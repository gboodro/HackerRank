# https://www.hackerrank.com/challenges/power-of-large-numbers

import sys

def powMod(a, p, m):
    if p < 2:
        if p == 1:
            return a % m
        else:
            return 1
    else:
        v = powMod(a, p//2, m)
        v *= v
        v = v % m;
        if p % 2 == 0:
            return v
        else:
            return (v*a) % m
            
def PowMod(a, b, m):
    if a % m == 0:
        return 0
    else:
        return powMod(a % m, b % (m-1), m)

n = int(sys.stdin.readline());
for i in range(0, n):
    m = sys.stdin.readline().split(" ")
    print(PowMod(int(m[0]), int(m[1]), 1000000007));