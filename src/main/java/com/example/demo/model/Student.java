package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long std_id;

    @Column(name= "std_name")
    private String std_name;
    
    @Column(name= "std_email")
    private String std_email;
    
    @Column(name= "std_age")
    private int std_age;

	public long getStd_id() {
		return std_id;
	}

	public void setStd_id(long std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public String getStd_email() {
		return std_email;
	}

	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}

	public int getStd_age() {
		return std_age;
	}

	public void setStd_age(int std_age) {
		this.std_age = std_age;
	}

	public Student(long std_id, String std_name, String std_email, int std_age) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_email = std_email;
		this.std_age = std_age;
	}
    
    public Student() {
    	
    }

	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", std_name=" + std_name + ", std_email=" + std_email + ", std_age="
				+ std_age + "]";
	}
    
    
    
	

}
