package com.spring.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.ProductDao;
import com.spring.model.Product;


public class ProductDaoImpl implements ProductDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	
	public void insertProduct(Product product)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(product);
		session.getTransaction().commit();
		
	}
	
	


 
	
}