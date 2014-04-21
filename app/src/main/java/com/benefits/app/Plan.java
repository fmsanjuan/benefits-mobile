package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;

public class Plan extends DomainEntity {

    private Goals goal;

    // RelationShip
    private Collection<Issue> issues;
    private Collection<Customer> customers;
    private Diet diet;
    private Training training;
    private Collection<Comment> comments;

    public Plan() {
        super();
        customers = new ArrayList<Customer>();
        comments = new ArrayList<Comment>();
        issues = new ArrayList<Issue>();
    }

    public Goals getGoal() {
        return goal;
    }

    public void setGoal(Goals goal) {
        this.goal = goal;
    }

    public Collection<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Issue> issues) {
        this.issues = issues;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

}
