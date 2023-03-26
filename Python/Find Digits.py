# https://www.hackerrank.com/challenges/find-digits

def count(t):
    d = t
    c = 0
    while d > 0:
        v = d % 10
        d //= 10
        if v != 0 and t % v == 0:
            c += 1
    return c

n = int(input())
for i in range(n):
    print(count(int(input())))