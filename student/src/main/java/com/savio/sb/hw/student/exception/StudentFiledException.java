package com.savio.sb.hw.student.exception;

public class StudentFiledException extends Exception {

	public StudentFiledException(String message) {

		super(message);
	}

	public StudentFiledException(String message,Throwable th) {

		super(message,th);
	}



}
