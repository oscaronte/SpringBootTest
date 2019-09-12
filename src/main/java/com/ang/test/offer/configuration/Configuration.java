package com.ang.test.offer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class Configuration {
	@Autowired
	  private Environment env;
	
	 @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 LocalContainerEntityManagerFactoryBean entityManagerFactory =
	        new LocalContainerEntityManagerFactoryBean();
	    
	    //entityManagerFactory.setDataSource(dataSource);
	    
	    // Classpath scanning of @Component, @Service, etc annotated class
	    entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
	    
	    return entityManagerFactory;
	  }
}
