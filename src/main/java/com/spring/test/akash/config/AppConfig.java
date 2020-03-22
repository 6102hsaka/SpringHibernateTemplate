package com.spring.test.akash.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.test.akash.dao.EmployeeDaoImpl;
import com.spring.test.akash.model.Department;
import com.spring.test.akash.model.Employee;

@Configuration
@ComponentScan("com.spring.test.akash")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean("ds")
	public DriverManagerDataSource getDatasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("DRIVER_CLASS"));
		ds.setUrl(env.getProperty("DB_URL"));
		ds.setUsername(env.getProperty("DB_USER"));
		ds.setPassword(env.getProperty("DB_PASS"));
		return ds;
	}

	
	@Bean("sessionFactory")
	public LocalSessionFactoryBean getSession() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(getDatasource());
		
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.connection.autocommit", "true");
		session.setHibernateProperties(p);
		
		session.setAnnotatedClasses(Employee.class,Department.class);
		
		return session;
	}
	
	
	@Bean("template")
	public HibernateTemplate getHiberTemp() {
		HibernateTemplate hTemp = new HibernateTemplate();
		hTemp.setSessionFactory(getSession().getObject());
		return hTemp;
	}
	
	@Bean
	public HibernateTransactionManager getTransaction() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(getSession().getObject());
		return htm;
	}
	
	@Bean
	public EmployeeDaoImpl getEmpDao() {
		EmployeeDaoImpl eDao = new EmployeeDaoImpl();
		return eDao;
	}
}
