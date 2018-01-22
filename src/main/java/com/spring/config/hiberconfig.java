package com.spring.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.dao.AddressDAO;
import com.spring.dao.*;
import com.spring.daoimpl.*;
import com.spring.model.*;

@Configuration
@ComponentScan("com.spring")
@EnableTransactionManagement
public class hiberconfig {
	
	 @Bean(name = "dataSource")
	 public DataSource getDataSource() {

			DriverManagerDataSource dataSource = new DriverManagerDataSource();

			dataSource.setDriverClassName("org.h2.Driver");

			dataSource.setUrl("jdbc:h2:tcp://localhost/~/boutique1");

			dataSource.setUsername("sa");

			dataSource.setPassword("");

			System.out.println("Datasource");

			return dataSource;



		}



		private Properties getHibernateProperties() {

			Properties properties = new Properties();

			properties.put("hibernate.show_sql", "true");

			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

			//properties.put("hibernate.hbm2ddl.auto", "create");

			properties.put("hibernate.hbm2ddl.auto", "update");

			System.out.println("Hibernate Properties");

			return properties;



		}



		@Autowired

	    @Bean(name="sessionFactory")

	    public SessionFactory getHibersession(DataSource datasource)

	    {

	    	LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(datasource);

	    	lsfb.addProperties(getHibernateProperties());

	    	lsfb.addAnnotatedClass(User.class);// mapping classes mapping model objects

	    	lsfb.addAnnotatedClass(Supplier.class);

	    	lsfb.addAnnotatedClass(Category.class);

	    	lsfb.addAnnotatedClass(Product.class);
	    	lsfb.addAnnotatedClass(Cart.class);
	    	lsfb.addAnnotatedClass(Order.class);
	    	lsfb.addAnnotatedClass(Payment.class);
	    	lsfb.addAnnotatedClass(Address.class);



	    	return lsfb.buildSessionFactory();

	    }



		@Autowired

		@Bean(name = "transactionManager")

		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			System.out.println("Transaction");

			return transactionManager;

		}	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory)
	{
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getcartDao(SessionFactory sessionFactory)
	{
		return new CartDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="orderDAO")
	public OrderDAO getordersDao(SessionFactory sessionFactory)
	{
		return new OrderDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="addressDAO")
	public AddressDAO getaddressDao(SessionFactory sessionFactory)
	{
		return new AddressDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="paymentDAO")
	public PaymentDAO getpaymentDao(SessionFactory sessionFactory)
	{
		return new PaymentDAOImpl(sessionFactory);
	}
	
	
}

