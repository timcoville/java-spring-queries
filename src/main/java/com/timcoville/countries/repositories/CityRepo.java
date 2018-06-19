package com.timcoville.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.timcoville.countries.models.City;

public interface CityRepo extends CrudRepository<City, Long> {

}
