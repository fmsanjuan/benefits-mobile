package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;

public class Food extends DomainEntity {

	private String name;
	private String description;

	// relationShip

	private Collection<Amount> amounts;

	public Food() {
		super();
		amounts = new ArrayList<Amount>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Amount> getAmounts() {
		return amounts;
	}

	public void setAmounts(Collection<Amount> amounts) {
		this.amounts = amounts;
	}

}
