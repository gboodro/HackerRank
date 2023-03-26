# https://www.hackerrank.com/contests/magic-lines-september-2015/challenges/game-of-thrones-mglines

s = raw_input()
count = {}
for i in range(len(s)):
    if s[i] not in count: count[s[i]] = 0
    count[s[i]] += 1
isPalindrome = True
hasOdd = False
if (sum(1 for x in count.values() if x % 2 == 1)): hasOdd = True
for k in count:
    if count[k] % 2 != 0:
        if hasOdd: hasOdd = False
        else:
            isPalindrome = False
            break
print "YES" if isPalindrome else "NO"
