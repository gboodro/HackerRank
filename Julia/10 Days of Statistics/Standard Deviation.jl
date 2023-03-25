# https://www.hackerrank.com/challenges/s10-standard-deviation

n = readline()
a = map(x -> parse(Int, x), split(readline(), " "))

τ = sum(a)//length(a)
sig = round(sqrt(sum(map(x -> (x-τ)^2, a)/length(a))),digits=1)
println(sig)