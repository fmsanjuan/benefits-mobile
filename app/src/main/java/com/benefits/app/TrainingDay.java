package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class TrainingDay extends DomainEntity implements Serializable {

	private Days name;

	// Relationships
	private Training training;
	private Collection<ExerciseGroup> exerciseGroups;

	public TrainingDay() {
		super();
		exerciseGroups = new ArrayList<ExerciseGroup>();
	}

	public Days getName() {
		return name;
	}

	public void setName(Days name) {
		this.name = name;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Collection<ExerciseGroup> getExerciseGroups() {
		return exerciseGroups;
	}

	public void setExerciseGroups(Collection<ExerciseGroup> exerciseGroups) {
		this.exerciseGroups = exerciseGroups;
	}

}
