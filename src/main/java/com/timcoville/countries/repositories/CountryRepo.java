package com.timcoville.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.timcoville.countries.models.Country;

public interface CountryRepo extends CrudRepository<Country, Long> {
	// 1. What query would you run to get all the countries that speak Slovene?
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage DESC")
	List<Object[]> findCountriesByLanguage(String Language);
	
	// 2. What query would you run to display the total number of cities for each country?
	@Query("SELECT c.name, COUNT(t.id) FROM Country c JOIN c.cities t GROUP BY c ORDER BY COUNT(t.id) DESC")
	List<Object[]> findNumOfCitiesforAllCountries();
	
	// 3. What query would you run to get all the cities in Mexico with a population of greater than 500,000?
	@Query("SELECT t.name, t.population FROM Country c JOIN c.cities t WHERE c.name = ?1 AND t.population >= ?2 ORDER BY t.population DESC")
	List<Object[]> findAllCitiesWithPopulationGreaterThan(String country, int population);
	
	// 4. What query would you run to get all languages in each country with a percentage greater than 89%? 
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >= ?1 ORDER BY l.percentage DESC")
	List<Object[]> findLanguagesByPercentageSpoken(double percentage);
	
	// 5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
	@Query ("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < ?1 AND c.population > ?2")
	List<Object[]> findCountriesBySurfaceAreaAndPopulation(double surface_area, int population);
	
	// 6. What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
	@Query ("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form = ?1 AND c.surface_area > ?2 AND c.life_expectancy > ?3")
	List<Object[]> findCountriesbyGovtANDSurfaceAreaANDLifeExpectancy(String government, double surface_area, double life_expectancy);
	
	// 7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000?
	@Query ("SELECT c.name, t.name, t.district, t.population FROM Country c JOIN c.cities t WHERE c.name = ?1 AND t.district = ?2 AND t.population > ?3")
	List<Object[]> findCitiesByCountryAndDistrictAndPopulation(String country, String district, int population);
	
	// 8. What query would you run to summarize the number of countries in each region?
	@Query ("SELECT c.region, COUNT(c.id) FROM Country c GROUP BY c.region ORDER BY COUNT(c.id) DESC")
	List<Object[]> findCountriesByRegion();
}
