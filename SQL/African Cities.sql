-- https://www.hackerrank.com/challenges/african-cities

select City.Name from City, Country
where City.CountryCode = Country.Code and Country.Continent = 'Africa';