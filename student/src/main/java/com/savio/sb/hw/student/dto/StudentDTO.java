package com.savio.sb.hw.student.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentDTO {

	@NotBlank(message = "Invalid BName")
	@NotNull(message = "Invalid Name")
	private String name;

	@NotBlank(message = "Invalid BEmail")
	@Email(message = "Invalid Email Entered")
	private String email;


	@Max(value = 30)
	@NotNull(message = "Invalid Age")
	private int age;

	@NotBlank(message = "Invalid BDepartment")
	@NotNull(message = "Invalid Department")
	private String dept;
	
	@NotBlank(message = "Invalid BYear")
	@NotNull(message = "Invalid Year")
	private String year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", email=" + email + ", age=" + age + ", dept=" + dept + ", year=" + year
				+ "]";
	}

	public String getstudDate(){
		if(year.equals("1st"))
			return "2021-04-10";
		else if(year.equals("2nd"))
			return "2020-04-10";
		else if(year.equals("3rd"))
			return "2019-04-10";
		else
			return "2018-04-10";
	}





			}


