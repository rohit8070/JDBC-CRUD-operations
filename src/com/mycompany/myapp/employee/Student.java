package com.mycompany.myapp.employee;

public class Student {
	private int rollno;
	private String name;
	private String password;
	private String email;

	public Student(int rollno, String name, String password, String email) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
}
