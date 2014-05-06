package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;


public class Day extends DomainEntity implements Serializable {

	private Days name;

	// relationship
	private Collection<Diet> diets;
	private Collection<Meal> meals;

	public Day() {
		super();
		meals = new ArrayList<Meal>();
	}

	public Days getName() {
		return name;
	}

	public void setName(Days name) {
		this.name = name;
	}

	@JsonIgnore
	public Collection<Diet> getDiets() {
		return diets;
	}

	public void setDiets(Collection<Diet> diets) {
		this.diets = diets;
	}

	public Collection<Meal> getMeals() {
		return meals;
	}

	public void setMeals(Collection<Meal> meals) {
		this.meals = meals;
	}

}
