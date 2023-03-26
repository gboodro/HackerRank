# https://www.hackerrank.com/contests/projecteuler/challenges/euler019

from datetime import date, timedelta, datetime
def count(day1, day2):
    week = timedelta(weeks=1)
    while day1.weekday() != 6:
        day1 += timedelta(days=1)
    ct = 0
    while day1 <= day2:
        if day1.day == 1:
            ct = ct + 1
        day1 += week 
    return ct

n = int(input())
m = 400
for i in range(n):
    spl1 = [int(x) for x in input().split(" ")]
    spl2 = [int(x) for x in input().split(" ")]
    day1 = date(spl1[0]%m+m, spl1[1], spl1[2])
    day2 = date(spl2[0] - spl1[0] + spl1[0]%m + m, spl2[1], 1)
    print(count(day1, day2))