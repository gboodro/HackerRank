# https://www.hackerrank.com/challenges/security-bijective-functions

n = input()
if n == len(set(raw_input().split(" "))):
    print "YES"
else:
    print "NO"