package com.savio.sb.hw.student.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savio.sb.hw.student.entity.Student;


@Repository
public class StudentDAOImpl extends BaseDAO{


	@Autowired
	private SessionFactory sFactory;

	public void save(Student stud) {
		Session session = sFactory.getCurrentSession();
		session.save(stud);
	}

	public Student getStudentById(int id) {
		Session session = sFactory.getCurrentSession();
		Student stud = session.get(Student.class, id);
		return stud;


	}
	public List<Student> getStudent(){
		Session session = sFactory.getCurrentSession();
		return session.createCriteria(Student.class).list();



	}
}
