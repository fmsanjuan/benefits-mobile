package com.benefits.app;

import java.io.Serializable;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;


public class Exercise extends DomainEntity implements Serializable {

	private String name;
	private String repetitions;
	private Integer cycles;
	private String description;
	private String urlYoutube;
	private byte[] image;
	private Language entityLanguage;

	// Relationships
	private Muscle muscle;
	private Collection<ExerciseGroup> exerciseGroups;

	public Exercise() {
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

	public String getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(String repetitions) {
		this.repetitions = repetitions;
	}

	public Integer getCycles() {
		return cycles;
	}

	public void setCycles(Integer cycles) {
		this.cycles = cycles;
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

	public Muscle getMuscle() {
		return muscle;
	}

	public void setMuscle(Muscle muscle) {
		this.muscle = muscle;
	}

	public String getUrlYoutube() {
		return urlYoutube;
	}

	public void setUrlYoutube(String urlYoutube) {
		this.urlYoutube = urlYoutube;
	}

	@JsonIgnore
	public Collection<ExerciseGroup> getExerciseGroups() {
		return exerciseGroups;
	}

	public void setExerciseGroups(Collection<ExerciseGroup> exerciseGroups) {
		this.exerciseGroups = exerciseGroups;
	}

}
