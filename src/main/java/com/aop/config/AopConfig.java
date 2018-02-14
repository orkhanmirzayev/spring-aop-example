package com.aop.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.aop" })
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.aop.repository" })
@PropertySource(value= {"classpath:application.properties"})
public class AopConfig {

	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(PersistenceUnitManager persistenceUnitManager) {
		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitManager(persistenceUnitManager);
		Properties p = new Properties();
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("show_sql", "true");
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		factoryBean.setJpaProperties(p);
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.afterPropertiesSet();

		return factoryBean.getNativeEntityManagerFactory();
	}

	@Bean
	public PersistenceUnitManager persistenceUnitManager(DataSource defaultDataSource) {
		final DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
		persistenceUnitManager.setDefaultDataSource(defaultDataSource);
		persistenceUnitManager.setPackagesToScan("com.aop.model");
		return persistenceUnitManager;
	}
}
