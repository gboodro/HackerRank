# https://www.hackerrank.com/contests/projecteuler/challenges/euler069

def minN(n):
    m = 1
    for i in [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]:
        if i * m < n:
            m *= i
        else:
            return m
    return m.toLong;
    
t = int(raw_input())
for i in range(0, t):
    print(minN(int(raw_input())))