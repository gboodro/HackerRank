# https://www.hackerrank.com/contests/projecteuler/challenges/euler065

def gcd(a, b):
    while b != 0:
        (a, b) = (b, a%b)
    return a

def c(n):
        if n % 3 == 2:
            return (n+1) // 3 * 2
        else:
            return 1
                
def getNum(n):
    num = 1
    den = c(n)
    n -= 1
    while n > 0:
        x = num
        y = den
        co = c(n)
        nn = y
        dd = co*y + x
        #g = gcd(nn, dd)
        num = nn
        den = dd
        n -= 1
    return [num, den];
                
def sumD(n):
    s = 0L
    num = n
    while(num > 0):
        s += num%10
        num /= 10
    return s
     
n = int(raw_input()) - 1
t = getNum(n)
num = 2*t[1] + t[0];
g = gcd(num, t[1]);
if n == 0:
    print(2)
else:
    print(sumD(num / g))