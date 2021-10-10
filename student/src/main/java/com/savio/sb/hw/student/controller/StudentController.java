package com.savio.sb.hw.student.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.savio.sb.hw.student.dto.LoginDTO;
import com.savio.sb.hw.student.dto.StudentDTO;
import com.savio.sb.hw.student.entity.Student;
import com.savio.sb.hw.student.entity.User;
import com.savio.sb.hw.student.service.StudentManager;

@Controller
public class StudentController extends BaseController{

	@Autowired
	private StudentManager studService;

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String viewStudentPage(Model model) {

		model.addAttribute("mystudent", new StudentDTO());

		return "register";

	}

	@RequestMapping(value="/doRegister",method=RequestMethod.POST)
	public ModelAndView viewStudentPage(@Valid @ModelAttribute("mystudent") StudentDTO student, BindingResult response) throws Exception {

		System.out.println(student.toString());
		ModelAndView mv = new ModelAndView("status");
		

		if(response.hasErrors()) {

			List<String> errMessage = response.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			errMessage.forEach(System.out::println);
			mv.setViewName("register");
			return mv;
		}


		//DATABASE ADDITION
		Student stud = new Student();


		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		String dateInString = student.getstudDate();
		Date date = formatter.parse(dateInString);
		stud.setAge(student.getAge());
		stud.setDate(date);
		stud.setEmail(student.getEmail());
		stud.setName(student.getName());
		stud.setDept(student.getDept());

		studService.save(stud);
		//END


		Student s = studService.fetchStudentById(stud.getId());
		mv.setViewName("status");
		mv.addObject("status", s.toString());
		mv.addObject("res",student);
		return mv;

	}
	
	
	///////////////////
	/*@RequestMapping(value="/login",method=RequestMethod.GET)
	public String viewLoginPage(Model model) {

		model.addAttribute("mylogin", new LoginDTO());
	
		
		return "login";

	}
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
    public String getLoginPage(@Valid @ModelAttribute("mylogin") LoginDTO login1, BindingResult response) throws Exception {
  	 
		 User usr1 = studService.fetchStudentByDetails("April0", " ");
	  
		  System.out.println(usr1.toString());
		  
		  return "loginstatus";
	}*/


}
