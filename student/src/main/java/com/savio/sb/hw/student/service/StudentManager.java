package com.savio.sb.hw.student.service;

import com.savio.sb.hw.student.entity.Student;
import com.savio.sb.hw.student.entity.User;
import com.savio.sb.hw.student.exception.NotAMajorAgeStudentException;

public interface StudentManager {
	public String getStudent();
	public boolean verifyAge(int age) throws NotAMajorAgeStudentException;
	void save(Student stud);
	Student fetchStudentById(int id);
	User fetchStudentByDetails(String user, String pass);
}
