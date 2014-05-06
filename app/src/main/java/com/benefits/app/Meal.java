package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Meal extends DomainEntity implements Serializable {

	private Meals name;
	private String description;

	// RelationShip
	private Collection<Day> days;
	private Collection<Amount> amounts;

	public Meal() {
		super();
		amounts = new ArrayList<Amount>();

	}

	public Meals getName() {
		return name;
	}

	public void setName(Meals name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Collection<Day> getDays() {
		return days;
	}

	public void setDays(Collection<Day> days) {
		this.days = days;
	}

	public Collection<Amount> getAmounts() {
		return amounts;
	}

	public void setAmounts(Collection<Amount> amounts) {
		this.amounts = amounts;
	}

}
