package com.savio.sb.hw.student.exception;


public class NotAMajorAgeStudentException extends Exception {

	public NotAMajorAgeStudentException(String message) {

		super(message);
	}

	public NotAMajorAgeStudentException(String message,Throwable th) {

		super(message,th);
	}



}
