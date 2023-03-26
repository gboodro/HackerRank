# https://www.hackerrank.com/contests/projecteuler/challenges/euler028

def sum(n):
    return (16*n**3+14*n)//3 - 6*n**2 - 3

t = int(raw_input())
for i in xrange(t):
    print sum(int(raw_input())//2+1) % 1000000007