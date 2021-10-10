package com.savio.sb.hw.student.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.savio.sb.hw.student.exception.NotAMajorAgeStudentException;
import com.savio.sb.hw.student.exception.StudentFiledException;


@ControllerAdvice
public class GlobalExceptionHandlerController {

	@ExceptionHandler(value= {StudentFiledException.class,NotAMajorAgeStudentException.class})
	public ModelAndView handleAgeErrors(Exception ex) {

		ModelAndView mvError = new ModelAndView();
		mvError.addObject("message",ex.getMessage());
		mvError.setViewName("error");

		ex.printStackTrace();

		return mvError;
	}



			@ExceptionHandler(Exception.class)
			public ModelAndView handleRTErrors(Exception ex) {

				ModelAndView mvError = new ModelAndView();
				mvError.addObject("message","System is not responding..");
				mvError.setViewName("error");

				ex.printStackTrace();

				return mvError;
			}
}
