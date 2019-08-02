package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.demo")
@EnableTransactionManagement
public class JpaConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lb = new LocalContainerEntityManagerFactoryBean();
		lb.setDataSource(dataSource());
		lb.setPackagesToScan("com.demo.entity");
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setShowSql(true);
		va.setDatabase(Database.MYSQL);
		va.setGenerateDdl(true);
		lb.setJpaVendorAdapter(va);
		
		return lb;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager tx=new JpaTransactionManager();
		tx.setEntityManagerFactory(entityManagerFactory().getObject());
		return tx;
	}
}
