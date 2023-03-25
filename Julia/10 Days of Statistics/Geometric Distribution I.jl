# https://www.hackerrank.com/challenges/s10-geometric-distribution-1

function binomial(n, k)
    return factorial(n) / factorial(k) / factorial(n-k)
end

reject = 1//3
good = 1-reject

defect_at_5 = good^4*reject^1

println(round(defect_at_5, digits = 3))