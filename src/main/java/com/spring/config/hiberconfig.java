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

import com.spring.dao.CategoryDao;
import com.spring.dao.SupplierDao;
import com.spring.dao.UserDao;
import com.spring.daoimpl.CategoryDaoImpl;
import com.spring.daoimpl.SupplierDaoImpl;
import com.spring.daoimpl.UserDaoImpl;

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

			properties.put("hibernate.hbm2ddl.auto", "create");

			//properties.put("hibernate.hbm2ddl.auto", "update");

			System.out.println("Hibernate Properties");

			return properties;



		}



		@Autowired

		@Bean(name = "sessionFactory")

		public SessionFactory getSessionFactory(DataSource dataSource) {

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

			sessionBuilder.addProperties(getHibernateProperties());

			sessionBuilder.scanPackages("com");

			System.out.println("Session");

			

			return sessionBuilder.buildSessionFactory();

			

		}



		@Autowired

		@Bean(name = "transactionManager")

		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			System.out.println("Transaction");

			return transactionManager;

		}	
	@Autowired
	@Bean(name="userDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	
}

