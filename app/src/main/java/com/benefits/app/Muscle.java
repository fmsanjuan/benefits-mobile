package com.benefits.app;

import java.io.Serializable;

public class Muscle extends DomainEntity implements Serializable {

	private String name;

	public Muscle() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
