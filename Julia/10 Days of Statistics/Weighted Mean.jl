# https://www.hackerrank.com/challenges/s10-weighted-mean

n = readline()
x = map(x -> parse(Int, x), split(readline(), " "))
w = map(x -> parse(Int, x), split(readline(), " "))

println(round(sum([a*b for (a, b) in zip(x, w)])/sum(w), digits=1))