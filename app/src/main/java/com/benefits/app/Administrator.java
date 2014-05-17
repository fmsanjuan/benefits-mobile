package com.benefits.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Administrator extends User implements Serializable{

	// RelationShip
	private Collection<Plan> plans;

	public Administrator() {
		super();
		plans = new ArrayList<Plan>();
	}


	public Collection<Plan> getPlans() {
		return plans;
	}

	public void setPlans(Collection<Plan> plans) {
		this.plans = plans;
	}

}
