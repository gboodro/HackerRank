# https://www.hackerrank.com/challenges/s10-poisson-distribution-2
λ_a = 0.88
λ_b = 1.55
t = 20
cost_a = sum(map(k -> (λ_a^k*exp(-λ_a)/factorial(k))*(160+40*k^2), 0:t))
cost_b = sum(map(k -> (λ_b^k*exp(-λ_b)/factorial(k))*(128+40*k^2), 0:t))
println(round(cost_a, digits = 3))
println(round(cost_b, digits = 3))