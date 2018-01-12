package com.spring.daoimpl;


import java.util.List;



import org.hibernate.HibernateException;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;





import com.spring.dao.*;

import com.spring.model.Category;
import com.spring.model.Supplier;





@Repository

public class CategoryDAOImpl implements CategoryDAO

{

	@Autowired

	SessionFactory sessionFactory;

	

	

	public CategoryDAOImpl(SessionFactory sessionFactory)

	{

		this.sessionFactory = sessionFactory;

	}

	public void insertCategory(Category category)

	{

		Session session=sessionFactory.openSession();

		session.beginTransaction();

		session.persist(category);

		session.getTransaction().commit();

		

	}

	public List<Category> retrieve()

	{

		Session session=sessionFactory.openSession();

		session.beginTransaction();

		List<Category>li=session.createQuery("from Category").list();

		session.getTransaction().commit();

		return li;

	}

	public Category findByCatId(int cid)

	{

		Session session=sessionFactory.openSession();

		Category c=null;

		try

		{

			session.beginTransaction();

			c= session.get(Category.class, cid);

			session.getTransaction().commit();

		}

		catch(HibernateException e)

		{

			System.out.println(e.getMessage());

			session.getTransaction().rollback();

		}

		return c;

	}
	public void updatecat(Category c)

	{

	Session session=sessionFactory.openSession();

	session.beginTransaction();
	

	
	session.update(c);

	session.getTransaction().commit();

	}

	public void deletecat(int cid)

	{

		Session session=sessionFactory.openSession();

		session.beginTransaction();

		Category c=(Category)session.get(Category.class,cid);

		session.delete(c);

		session.getTransaction().commit();

	}



}

