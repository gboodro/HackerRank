# https://www.hackerrank.com/challenges/s10-interquartile-range

n = readline()
x = map(x -> parse(Int, x), split(readline(), " "))
f = map(x -> parse(Int, x), split(readline(), " "))
a = []
for (xi,fi) in zip(x,f)
    for i in 1:fi
        push!(a,xi)
    end
end
sort!(a)
L = a[1:div(length(a),2)]
R = a[div(length(a)+3,2):length(a)]

q1 = round((L[div(length(L)+1,2)] + L[div(length(L)+2,2)])/2,digits=2)
q3 = round((R[div(length(R)+1,2)] + R[div(length(R)+2,2)])/2,digits=2)
println(round(q3-q1,digits=2))