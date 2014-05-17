package com.benefits.app;


import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;


public class Amount extends DomainEntity implements Serializable{
	private Integer quantity;
	private String measure;

	// relationship

	private Meal meal;
	private Food food;

	public Amount() {
		super();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	@JsonIgnore
	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}
