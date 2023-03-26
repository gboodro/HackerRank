-- https://www.hackerrank.com/challenges/average-population-of-each-continent

select Country.Continent, floor(avg(City.Population)) from City, Country
where City.CountryCode = Country.Code
group by Country.Continent;