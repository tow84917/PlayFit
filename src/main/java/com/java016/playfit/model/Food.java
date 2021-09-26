package com.java016.playfit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Float kcal;

	private String name;

	private String type;
	
	private String serving;

	//bi-directional many-to-one association to Meal
	@JsonIgnore
	@OneToMany(mappedBy="food")
	private List<Meal> meals;

	public Food() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getKcal() {
		return kcal;
	}

	public void setKcal(Float kcal) {
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@JsonIgnore
	public List<Meal> getMeals() {
		return meals;
	}
	
	@JsonIgnore
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public String getServing() {
		return serving;
	}

	public void setServing(String serving) {
		this.serving = serving;
	}
}
