package com.spring.daoimpl;


import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.UserDao;
import com.spring.model.User;

public class UserDaoImpl implements UserDao
{
 @Autowired
 SessionFactory sessionFactory;
 
 @Autowired
 public UserDaoImpl(SessionFactory sessionFactory)
 {
	 super();
	 this.sessionFactory=sessionFactory;
	 
 }
 @Transactional
 public boolean insertUser(User user)
 {
	Session session= sessionFactory.openSession(); 
	 
	session.beginTransaction();
	session.saveOrUpdate(user);
	session.getTransaction().commit();
	return true;
 }
 
}

