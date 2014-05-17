package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import org.codehaus.jackson.annotate.JsonIgnore;


public class Food extends DomainEntity implements Serializable {

	private String name;
	private String description;
	private byte[] image;
	private Language entityLanguage;

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

    @JsonIgnore
	public boolean getValidImage() {
		return !(this.getImage() == null || this.getImage().length == 0);
	}

	@JsonIgnore
	public Collection<Amount> getAmounts() {
		return amounts;
	}

	public void setAmounts(Collection<Amount> amounts) {
		this.amounts = amounts;
	}

	public Language getEntityLanguage() {
		return entityLanguage;
	}

	public void setEntityLanguage(Language entityLanguage) {
		this.entityLanguage = entityLanguage;
	}

}
