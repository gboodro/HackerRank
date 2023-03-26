# https://www.hackerrank.com/contests/pythonist/challenges/python-string-formatting

def binary(num):
    return str(bin(num))[2:]

def hexagonal(num):
    return str(hex(num))[2:].upper()

def noLeadingZeros(s):
    if s[0:1] == '0':
        return noLeadingZeros(s[1:])
    return s

def octal(num):
    return noLeadingZeros(str(oct(num)))

def pad(a, L):
    if(len(a) == L):
        return a
    return pad(" "+a, L)

n = int(raw_input())
nL = len(binary(n))

for i in xrange(1, n+1):
    print(pad(str(i), nL) + " " + pad(octal(i), nL) + " " + pad(hexagonal(i), nL) + " " + pad(binary(i), nL))