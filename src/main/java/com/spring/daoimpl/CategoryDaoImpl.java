package com.spring.daoimpl;


	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoryDao;
	import com.spring.model.Category;
	@Repository
	@Service
	public class CategoryDaoImpl implements CategoryDao
	{

		@Autowired
		SessionFactory sessionFactory;
		
		public CategoryDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}

		
		@Transactional
		public void insertCategory(Category category)
		{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(category);
			session.getTransaction().commit();
			
		}
		
		
		
	}


