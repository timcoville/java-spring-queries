package com.timcoville.countries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.timcoville.countries.repositories.CityRepo;
import com.timcoville.countries.repositories.CountryRepo;
import com.timcoville.countries.repositories.LanguageRepo;

@Service
public class ApiService {
	private final CountryRepo countryRepo;
	private final CityRepo cityRepo;
	private final LanguageRepo languageRepo;
	
	public ApiService(CountryRepo countryRepo, CityRepo cityRepo, LanguageRepo languageRepo) {
		this.countryRepo = countryRepo;
		this.cityRepo = cityRepo;
		this.languageRepo = languageRepo;
	}
	
	public List<Object[]> findbyLanguage(String language){
		return countryRepo.findCountriesByLanguage(language);
	}
	
	public List<Object[]> totalCitiesAndCountries(){
		return countryRepo.findNumOfCitiesforAllCountries();
	}
	
	public List<Object[]> allCitiesWithPopulationGreaterThan(String country, int population){
		return countryRepo.findAllCitiesWithPopulationGreaterThan(country, population);
	}
	
	public List<Object[]> allCitiesWithLanguageGreaterThanPercentage(double percentage){
		return countryRepo.findLanguagesByPercentageSpoken(percentage);
	}
	
	public List<Object[]> allCountriesbySurfaceAreaAndPopulation(double surface_area, int population){
		return countryRepo.findCountriesBySurfaceAreaAndPopulation(surface_area, population);
	}
	
	public List<Object[]> allCountriesbyGovtANDSurfaceANDPopulation(String government, double surface_area, double life_expectancy){
		return countryRepo.findCountriesbyGovtANDSurfaceAreaANDLifeExpectancy(government, surface_area, life_expectancy);
	}
	
	public List<Object[]> allCitiesByCountryAndDistrictAndPopulation(String country, String district, int population){
		return countryRepo.findCitiesByCountryAndDistrictAndPopulation(country, district, population);
	}
	
	public List<Object[]> countCountriesByRegion(){
		return countryRepo.findCountriesByRegion();
	}
	
}
