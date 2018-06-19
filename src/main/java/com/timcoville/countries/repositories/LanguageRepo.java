package com.timcoville.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.timcoville.countries.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Long> {

}
