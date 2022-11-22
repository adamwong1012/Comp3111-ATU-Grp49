package com.example.comp3111_project.Algorithms;

/*
 * This class can be ignored. 
 */

public class SimpleStringProperty {
	private String str;
	
	public SimpleStringProperty() {
		str = "";
	}
	
	public SimpleStringProperty(String str) {
		this.str = str;
	}
	
	public String get() { return str; }
	public void set(String str) { this.str = str; }
}
