# https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list

max1 = -101
max2 = -101

n = int(raw_input())
a = map(int, raw_input().split(" "))
for i in a:
    if i > max1:
        max2 = max1
        max1 = i
    elif i < max1 and i > max2:
        max2 = i
print(max2)