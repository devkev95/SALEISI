/**
 * Configuracion de Hibernate y cuestiones relacionadas.
 * En este caso en vez de usar la clase SessionFactory de Hibernate usamos
 * EntityManager de JPA ya que es el estandar y nos permite cambiar de manera
 * más facil de proveedor de JPA(Hibernate es un proveedor de JPA)
 */

package com.trabajotoo.saleisi.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

	@Resource
	Environment env;
	
	//Configuracion del datasource de Apache Commons dbpc2
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/sistemaLabEISI");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		
		return dataSource;
	}
	
	// Configuracion de las propiedades de Hibernate
	private Properties hibProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	    properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	        
	  
	    return properties; 
	}
	
	// Registro del datasource, Hibernate y el paquete en el cual estan registradas
	// las clases que representan el modelo de la BD 
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(dataSource());
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            entityManagerFactoryBean.setPackagesToScan("com.trabajotoo.saleisi.model");
                             
            entityManagerFactoryBean.setJpaProperties(hibProperties());
             
            return entityManagerFactoryBean;
    }
	
	// Configuracion del manejador de transaciones de la BD con JPA
	@Bean
    public JpaTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            
            return transactionManager;
    }
}
