package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Day extends DomainEntity implements Serializable{

	private Days name;

	// relationship
	private Diet diet;
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

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

	public Collection<Meal> getMeals() {
		return meals;
	}

	public void setMeals(Collection<Meal> meals) {
		this.meals = meals;
	}

}
