# https://www.hackerrank.com/challenges/s10-poisson-distribution-1
λ = 2.5
k = 5
p = λ^k*exp(-λ)/factorial(k)
println(round(p, digits = 3))