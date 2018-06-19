package com.timcoville.countries.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Language {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	private String country_code;
	private Boolean is_official;
	private double percentage;
	private String language;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
	
   	public Language() {

	}
   	
   	
   	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}




	public String getCountry_code() {
		return country_code;
	}



	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}



	public Boolean getIs_official() {
		return is_official;
	}



	public void setIs_official(Boolean is_official) {
		this.is_official = is_official;
	}



	public double getPercentage() {
		return percentage;
	}



	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public Country getCountry() {
		return country;
	}



	public void setCountry(Country country) {
		this.country = country;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
