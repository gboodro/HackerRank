# https://www.hackerrank.com/challenges/find-a-string

c = 0
s = raw_input()
sLen = len(s)
sub = raw_input()
subLen = len(sub)
for i in xrange(sLen-subLen):
    if s[i:i+subLen] == sub:
        c += 1
print(c)