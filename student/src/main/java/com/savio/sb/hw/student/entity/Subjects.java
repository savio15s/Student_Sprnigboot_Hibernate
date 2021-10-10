package com.savio.sb.hw.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_subjects")
public class Subjects {


	@Id
	private String sub;

	private int marks;
	private String teacher;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ttype",referencedColumnName = "id")
	private Teacher type;

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Teacher getType() {
		return type;
	}

	public void setType(Teacher type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Subjects [sub=" + sub + ", marks=" + marks + ", teacher=" + teacher + ", type=" + type + "]";
	}





}
