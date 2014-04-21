package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;

public class Sponsor extends DomainEntity {

	private String name;
	private String address;
	private String email;
	private int phone;

	// relationSHip
	private Collection<Training> trainings;
	private Collection<Diet> diets;

	public Sponsor() {
		super();
		trainings = new ArrayList<Training>();
		diets = new ArrayList<Diet>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Collection<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Collection<Training> trainings) {
		this.trainings = trainings;
	}

	public Collection<Diet> getDiets() {
		return diets;
	}

	public void setDiets(Collection<Diet> diets) {
		this.diets = diets;
	}

}
