# https://www.hackerrank.com/contests/projecteuler/challenges/euler097

def pad(s):
    if len(s) < 12:
        return pad("0" + s)
    return s

m = 10**12
def f(a, b, c, d):
    return ((pow(b, c, m) * a) % m + d) % m

t = int(raw_input())
s = 0
for i in xrange(0, t):
    a = map(int, raw_input().split())
    s += f(a[0], a[1], a[2], a[3])
print(pad(str(s % m)))