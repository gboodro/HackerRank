# https://www.hackerrank.com/challenges/map-and-lambda-expression

n = int(raw_input())
(a, b) = (0, 1)
L = []
for i in xrange(0, n):
    L.append(a)
    a, b = b, a+b
print map(lambda a : a**3, L)