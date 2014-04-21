package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;

public class Meal extends DomainEntity {

	private Meals name;

	// RelationShip
	private Day day;
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

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Collection<Amount> getAmounts() {
		return amounts;
	}

	public void setAmounts(Collection<Amount> amounts) {
		this.amounts = amounts;
	}

}
