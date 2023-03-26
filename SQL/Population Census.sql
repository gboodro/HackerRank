-- https://www.hackerrank.com/challenges/asian-population

select sum(City.Population) from City, Country
where City.CountryCode = Country.Code and Country.Continent = 'Asia';