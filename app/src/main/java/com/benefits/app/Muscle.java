package com.benefits.app;


import java.io.Serializable;

public class Muscle extends DomainEntity implements Serializable{

	private String name;
	private Language entityLanguage;

	public Muscle() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language getEntityLanguage() {
		return entityLanguage;
	}

	public void setEntityLanguage(Language entityLanguage) {
		this.entityLanguage = entityLanguage;
	}

}
