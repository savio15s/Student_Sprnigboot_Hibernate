package com.savio.sb.hw.student.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tbl_student")
public class Student {


	@Id
	@SequenceGenerator(name="seq",sequenceName="oracle_seq")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
	@Column(name = "StuUD",nullable = false)
	private int id;


	@Column(name = "StuName",nullable = false,length = 200)
	private String name;

	@Column(name = "StuEmail",unique = true,length = 150)
	private String email;

	@Column(name = "StuAge")
	private int age;

	@Column(name = "Dept",nullable = false,length = 50)
	private String dept;

	@Column(name = "Year")
	@Temporal(TemporalType.DATE)
	private Date date;


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "StuUD")
	private List<Subjects> sb;


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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public List<Subjects> getSb() {
		return sb;
	}


	public void setSb(List<Subjects> sb) {
		this.sb = sb;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", dept=" + dept
				+ ", date=" + date + ", sb=" + sb + "]";
	}







}
