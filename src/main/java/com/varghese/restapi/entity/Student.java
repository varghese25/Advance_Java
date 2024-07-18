package com.varghese.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollNo;
	
	@Column(name="student_name") // Explicity given column name or we can keep field name as column name
	private String name;
	@Column(name="student_percentage")
	private float percentage;
	@Column(name="student_branch")
	private String branch;
	
	public Student(){ // Constructor
		
		
		
	}
	
	
	
	public Student(String name, float percentage, String branch) {  // Parameterzed Constructor
		super();
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}



	public int getRollNo() { // Getter & Setters 
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ "]";
	}
	
	

}
