# https://www.hackerrank.com/challenges/s10-binomial-distribution-2

function binomial(n, k)
    return factorial(n) / factorial(k) / factorial(n-k)
end

reject = 0.12
good = 1-reject

less_than_3_rejects = sum(map(x -> binomial(10,x) * reject^x * good^(10-x), 0:2))
at_least_2_rejects = sum(map(x -> binomial(10,x) * reject^x * good^(10-x), 2:10))

println(round(less_than_3_rejects, digits = 3))
println(round(at_least_2_rejects, digits = 3))