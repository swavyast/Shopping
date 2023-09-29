package eCommerce.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import eCommerce.model.Catagory;

public class DBConfig {
	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/mlTest");
		dataSource.setUsername("delphic");
		dataSource.setPassword("Delph!c");
		System.out.println("-----DataSourceCreatedSuccessfully------");
		return dataSource;
	}
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder lsfBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		lsfBuilder.addProperties(hibernateProp);
		lsfBuilder.addAnnotatedClass(Catagory.class);
		lsfBuilder.addAnnotatedClass(getClass());
		
		
		
		
		System.out.println("----Session Factory Object Created-----");
		return lsfBuilder.buildSessionFactory();
	}
	
	@Bean(name = "txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("----TransactionManager Object Created----");
		return new HibernateTransactionManager(sessionFactory);
		
	}
}
