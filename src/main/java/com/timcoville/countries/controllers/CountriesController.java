package com.timcoville.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timcoville.countries.service.ApiService;

@Controller
public class CountriesController {
	
	private final ApiService apiService;
	public CountriesController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> countries = apiService.countCountriesByRegion();
		model.addAttribute("countries", countries);
		return "index.jsp";
	}
	
}
