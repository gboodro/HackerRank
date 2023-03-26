# https://www.hackerrank.com/contests/pythonist/challenges/python-sort-sort

con = raw_input().split(" ")
m = int(con[0])
n = int(con[1])
L = []
for i in xrange(0, m):
    L.append(raw_input().split(" "))
k = int(raw_input())
s = sorted(L, key=lambda x: int(x[k]))
print("\n".join(map(lambda x: " ".join(x), s)))