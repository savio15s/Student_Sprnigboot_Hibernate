package com.savio.sb.hw.student.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savio.sb.hw.student.entity.Student;
import com.savio.sb.hw.student.entity.User;

@Repository
public class UserDAOImpl extends BaseDAO {

	@Autowired
	private SessionFactory sFactory;

	public void save(User user) {
		Session session = sFactory.getCurrentSession();
		session.save(user);
	}
	
	public User getStudentByDetails(String user,String pass) {
		Session session = sFactory.getCurrentSession();
		User usr = session.get(User.class, user);
		return usr;


	}

}
