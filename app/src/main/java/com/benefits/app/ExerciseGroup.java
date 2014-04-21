package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;

public class ExerciseGroup extends DomainEntity {

	private String name;

	// Relationships
	private Collection<Exercise> exercises;
	private Collection<TrainingDay> trainingDays;

	public ExerciseGroup() {
		super();
		exercises = new ArrayList<Exercise>();
		trainingDays = new ArrayList<TrainingDay>();
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

	public Collection<TrainingDay> getTrainingDays() {
		return trainingDays;
	}

	public void setTrainingDays(Collection<TrainingDay> trainingDays) {
		this.trainingDays = trainingDays;
	}

}
