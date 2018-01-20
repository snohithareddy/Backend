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
import com.spring.dao.CartDAO;
import com.spring.dao.CategoryDAO;
import com.spring.dao.OrdersDAO;
import com.spring.dao.PaymentDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SupplierDAO;
import com.spring.dao.UserDAO;
import com.spring.daoimpl.AddressDAOImpl;
import com.spring.daoimpl.CartDAOImpl;
import com.spring.daoimpl.CategoryDAOImpl;
import com.spring.daoimpl.OrdersDAOImpl;
import com.spring.daoimpl.PaymentDAOImpl;
import com.spring.daoimpl.ProductDAOImpl;
import com.spring.daoimpl.SupplierDAOImpl;
import com.spring.daoimpl.UserDAOImpl;
import com.spring.model.Address;
import com.spring.model.Cart;
import com.spring.model.Category;
import com.spring.model.Orders;
import com.spring.model.Payment;
import com.spring.model.Product;
import com.spring.model.Supplier;
import com.spring.model.User;

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
	    	lsfb.addAnnotatedClass(Orders.class);
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
	@Bean(name="ordersDAO")
	public OrdersDAO getordersDao(SessionFactory sessionFactory)
	{
		return new OrdersDAOImpl(sessionFactory);
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

