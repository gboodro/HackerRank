# https://www.hackerrank.com/challenges/s10-geometric-distribution-2/

function binomial(n, k)
    return factorial(n) / factorial(k) / factorial(n-k)
end

reject = 1//3
good = 1-reject

defect_at_5_or_before = sum(map(x -> good^(x-1)*reject^1, 1:5))

println(round(defect_at_5_or_before, digits = 3))