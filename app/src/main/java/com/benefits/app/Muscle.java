package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Muscle extends DomainEntity implements Serializable {

	private String name;

	// Relationships
	private Collection<Exercise> exercises;

	public Muscle() {
		super();
		exercises = new ArrayList<Exercise>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Collection<Exercise> exercises) {
		this.exercises = exercises;
	}

}
