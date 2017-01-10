package com.group5.store.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.group5.store")
public class RootContextConfig {

	@Bean(name = "datasource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/store_db");
		dataSource.setUsername("root");
		dataSource.setPassword("1");

		return dataSource;
	}

	@Bean(name = "dataSourceInitializer")
	public DataSourceInitializer dataSourceInitializer(DriverManagerDataSource dataSource) {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setSqlScriptEncoding("utf8");

		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(populator);

		return initializer;
	}

	

	@Bean(name = "localSessionFactoryBean")
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.group5.store.model.entity");
		sessionFactoryBean.setHibernateProperties(hibProperties());
		return sessionFactoryBean;
	}
	
	private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");
        
        return properties;  
    }

	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory,
			DriverManagerDataSource dataSource) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		transactionManager.setDataSource(dataSource);

		return transactionManager;
	}
}
