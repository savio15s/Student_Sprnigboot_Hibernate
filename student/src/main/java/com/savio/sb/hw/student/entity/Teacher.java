package com.savio.sb.hw.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_teachers")
public class Teacher {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String tname;

	private String tdept;

	public String getTdept() {
		return tdept;
	}

	public void setTdept(String tdept) {
		this.tdept = tdept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tname=" + tname + "]";
	}



}
