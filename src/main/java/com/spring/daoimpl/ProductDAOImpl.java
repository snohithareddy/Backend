package com.spring.daoimpl;



import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;

import com.spring.model.Product;

@Repository

public class ProductDAOImpl implements ProductDAO

{

	@Autowired

	SessionFactory sessionFactory;

	

	public ProductDAOImpl(SessionFactory sessionFactory)

	{

		this.sessionFactory=sessionFactory;

	}



	public  void insertProduct(Product product) {

		Session session=sessionFactory.openSession();

		session.beginTransaction();

		session.save(product);

		session.getTransaction().commit();

		}



	public List<Product> retrieve() {

		Session session=sessionFactory.openSession();

		session.beginTransaction();

		List<Product> li=session.createQuery("from Product").list();

		session.getTransaction().commit();

		return li;

	}





	public Product findByPID(int pid) {

	Session session=sessionFactory.openSession();

	Product p=null;

	try{

		session.beginTransaction();

		p=session.get(Product.class,pid);

		session.getTransaction().commit();

		}

	catch(HibernateException e)

	{

		e.printStackTrace();

		session.getTransaction().rollback();

	}

	

	return p;

	

}



public List<Product> getProdByCatId(int cid) {

	Session session=sessionFactory.openSession();

	List<Product> prod= null;

	try{

		session.beginTransaction();

		prod=session.createQuery("from Product where cid=" +cid).list();

		session.getTransaction().commit();

	}

	catch(Exception e)

	{

		e.printStackTrace();

		session.getTransaction().rollback();

	}

	

	return prod;

}

public void updateprod(Product p)

{

Session session=sessionFactory.openSession();

session.beginTransaction();

session.update(p);

session.getTransaction().commit();

}

public void deleteProd(int pid)

{

	Session session=sessionFactory.openSession();

	session.beginTransaction();

	Product p=(Product)session.get(Product.class,pid);

	session.delete(p);

	session.getTransaction().commit();

}


@Transactional
public List<Product> getProductByCategoryID(int cid) {
	String hql = "from Product where cid= "+cid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Product> catproducts = (List<Product>) query.list();
	return catproducts;

}












}