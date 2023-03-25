# https://www.hackerrank.com/challenges/s10-basic-statistics

n = readline()
a = sort(map(x -> parse(Int, x), split(readline(), " ")))
println(round(sum(a)/length(a), digits=1))
println(round((a[div(length(a)+1, 2)] + a[div(length(a)+2, 2)])/2, digits=1))
u=unique(a)
d=Dict([(i,count(x->x==i,a)) for i in u])
maxval = maximum(values(d))
println(minimum([k for (k, v) in d if v == maxval]))