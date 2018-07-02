package com.example.demo;

public class Student {

	String name;
	int id;
	String school;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	Student(){
		
	}
	
	Student(String name, int i, String s) {
		this.name = name;
		this.id = i;
		school = s;
	}
}
