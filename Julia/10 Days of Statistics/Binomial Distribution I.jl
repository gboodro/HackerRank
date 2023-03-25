# https://www.hackerrank.com/challenges/s10-binomial-distribution-1

function binomial(n, k)
    return factorial(n) / factorial(k) / factorial(n-k)
end

p_boy = 1.09/(1+1.09)
p_girl = 1-p_boy

p_3_or_more_boys = sum(map(x -> binomial(6,x) * p_boy^x * p_girl^(6-x), 3:6))

println(round(p_3_or_more_boys, digits = 3))