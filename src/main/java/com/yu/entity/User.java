package com.yu.entity;


public class User {
	
	private int id;
	private String name;
	private int age;
	private double salary;
	private String birthday;
	private float score;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	

	@Override
	public String toString() {
		return "name:"+name+"age:"+age+"salary:"+salary+"birthday:"+birthday+"score"+score;
	}
}