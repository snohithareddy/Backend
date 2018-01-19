package com.spring.daoimpl;





import org.hibernate.Criteria;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.criterion.Projections;

import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



import com.spring.dao.UserDAO;

import com.spring.model.User;





@Repository

public class UserDAOImpl implements UserDAO

{

	public  UserDAOImpl(){}

 @Autowired

 SessionFactory sessionFactory;

 

 @Autowired

 public UserDAOImpl(SessionFactory sessionFactory)

 {

	 super();

	 this.sessionFactory=sessionFactory;

	 

 }



 public boolean insertUser(User user)

 {

	Session session= sessionFactory.openSession(); 

	 

	session.beginTransaction();

	session.save(user);

	session.getTransaction().commit();

	return true;

 }



@SuppressWarnings("deprecation")

@Override

public User getUserId(String email) {



	Criteria c=sessionFactory.openSession().createCriteria(User.class);

	c.add(Restrictions.eq("email", email));

	

	return  (User) c.uniqueResult();

	

	

               

}

 

}