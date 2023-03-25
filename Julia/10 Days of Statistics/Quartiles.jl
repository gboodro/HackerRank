# https://www.hackerrank.com/challenges/s10-quartiles

n = readline()
a = sort(map(x -> parse(Int, x), split(readline(), " ")))
L = a[1:div(length(a),2)]
R = a[div(length(a)+3,2):length(a)]

println(div((L[div(length(L)+1,2)] + L[div(length(L)+2,2)]),2))
println(div((a[div(length(a)+1,2)] + a[div(length(a)+2,2)]),2))
println(div((R[div(length(R)+1,2)] + R[div(length(R)+2,2)]),2))