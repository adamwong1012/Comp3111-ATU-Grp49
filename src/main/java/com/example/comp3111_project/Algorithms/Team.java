package com.example.comp3111_project.Algorithms;

public class Team {
	private int id;
	private double k1_average;
	private double k2_average;
	private Person students[] = new Person[4];
	private int student_no;
	
	// Note: when a team is created, a student MUST be present in the team
	public Team(int id, Person student) {
		this.id = id;
		k1_average = 0;
		k2_average = 0;
		student_no = 0;
		addStudent(student);
	}
	
	// setter
	public boolean addStudent(Person student) {
		if (student_no >= 4) {
			return false;
		}
		students[student_no++] = student;
		k1_average = (k1_average * (student_no-1) + Integer.parseInt(student.getK1energy())) / student_no;
		k2_average = (k2_average * (student_no-1) + Integer.parseInt(student.getK2energy())) / student_no;
		return true;
	}
	
	// getters
	public int getID() { return id; }
	public double getK1() { return k1_average; }
	public double getK2() { return k2_average; }
	public int getPersonNo () { return student_no; }
	public Person getPersonAt(int idx) { 
		if (idx < 0 || idx >= student_no) {
			return null;
		}
		return students[idx];
	}

	public Person[] getStudentList() {
		return this.students;
	}
	
}
