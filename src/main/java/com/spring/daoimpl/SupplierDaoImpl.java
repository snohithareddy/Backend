package com.spring.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SupplierDao;
import com.spring.model.Supplier;


@Repository
@Service
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Transactional
	public void insertSupplier(Supplier supplier)
	{
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.persist(supplier);
	session.getTransaction().commit();
	}
	public List<Supplier> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> li = session.createQuery("from supplier").list();
		session.getTransaction().commit();
		return li;
	}
	
	}