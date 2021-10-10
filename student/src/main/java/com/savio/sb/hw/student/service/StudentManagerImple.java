package com.savio.sb.hw.student.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savio.sb.hw.student.entity.Role;
import com.savio.sb.hw.student.entity.Student;
import com.savio.sb.hw.student.entity.Subjects;
import com.savio.sb.hw.student.entity.Teacher;
import com.savio.sb.hw.student.entity.User;
import com.savio.sb.hw.student.exception.NotAMajorAgeStudentException;
import com.savio.sb.hw.student.repo.StudentDAOImpl;
import com.savio.sb.hw.student.repo.UserDAOImpl;

@Service
@Transactional
public class StudentManagerImple implements StudentManager {

	@Autowired
	private StudentDAOImpl repo;
	@Autowired
	private UserDAOImpl urepo;

	@Override
	public String getStudent(){

		//int j =10/0;
		return "Henry";
	}

	@Override
	public boolean verifyAge(int age)throws NotAMajorAgeStudentException{
		if(age<18) {
			throw new NotAMajorAgeStudentException("Under Age Student, Service Blocked");

		}
		return true;

	}
	enum Esubjects{
		Maths,Computer,Graphics,Physics;
	}
	enum ETeachers{
		Bob,Alice,John,Tom;
	}
	enum EDept{
		ECE,CSE,CIVIL,MECH;
	}
	@Override
	public void save(Student stud) {

		Esubjects sarr[] = Esubjects.values();
		ETeachers tarr[] = ETeachers.values();
		EDept darr[] = EDept.values();
		List<Subjects> subjects = new ArrayList<>();
		for(int i=0;i<4;i++){
			Teacher tType = new Teacher();
			tType.setTname(tarr[i].toString());
			tType.setTdept(darr[i].toString());
			Subjects sa = new Subjects();

			sa.setSub(sarr[i].toString());
			sa.setMarks((20*i)+3);

			sa.setTeacher(tarr[i].toString());
			sa.setType(tType);
			subjects.add(sa);
		}
		stud.setSb(subjects);
		User usr = new User();
		usr.setUserid(stud.getName()+(int)Math.random()*100);
		usr.setEmail(stud.getEmail());
		usr.setPassword(stud.getName()+stud.getAge());

		Role r1 = new Role();
		r1.setRoleId("Student");
		r1.setDescription("General Student");

		Role r2 = new Role();
		r2.setRoleId("Leader");
		r2.setDescription("Head Student");

		List<Role> roles = new ArrayList<>();
		roles.add(r1);
		roles.add(r2);
		usr.setRoles(roles);
		urepo.save(usr);;
		repo.save(stud);
	}
	@Override
	public Student fetchStudentById(int id) {
		return repo.getStudentById(id);
	}
	@Override
	public User fetchStudentByDetails(String user,String pass) {
		return urepo.getStudentByDetails(user, pass);
	}
	
	
	
	
}
