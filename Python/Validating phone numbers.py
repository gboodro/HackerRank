# https://www.hackerrank.com/contests/pythonist/challenges/validating-the-phone-number

import re
for i in xrange(0, input()):
    s = raw_input()
    if len(s) == 10 and re.search("[7-9]\d\d\d\d\d\d\d\d\d", s):
        print("YES")
    else:
        print("NO")