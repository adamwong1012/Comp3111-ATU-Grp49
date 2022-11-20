package com.example.comp3111_project;

public class SortingEntity {
	// properties
	private Person student;
	private Team team;
	private double data_d;
	private int index;			// Note: this property is only for Person
	
	public SortingEntity(Person student) {	// Initialising using Person 
		this.student = student;
		this.team = null;
		this.data_d = 0;
		this.index = -1;
	}
	public SortingEntity(Team team) {		// Initialising using Team
		this.student = null;
		this.team = team;
		this.data_d = 0;
		this.index = -1;
	}
	
	public SortingEntity(SortingEntity entity) {	// Copy Constructor
		student = entity.student;
		team = entity.team;
		data_d = entity.data_d;
		index = entity.index;
	}
	
	// setters
	public void setPerson(Person student) { this.student = student; }
	public void setTeam(Team team) { this.team = team; }
	public void setData(double data) { data_d = data; }
	public void setIndex(int idx) { index = idx; }
	
	// getters
	public Person getPerson() { return student; }
	public Team getTeam() { return team; }
	public double getData() { return data_d; }
	public int getIndex() { return index; }
}