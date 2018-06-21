package com.admin.product.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
//@ComponentScan(basePackages="com.admin.product.repo")
public class DataSrouceConfig {
	
	
	@Bean
	public BasicDataSource dataSrouce() {
		BasicDataSource dataSrouce = new BasicDataSource();
		dataSrouce.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSrouce.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
		dataSrouce.setUsername("root");
		dataSrouce.setPassword("root");
		dataSrouce.setInitialSize(1);
		dataSrouce.setMaxActive(2);
		return dataSrouce;
		
	}
	
	//remove this configration for add jdbc starter
	//<artifactId>spring-boot-starter-jdbc</artifactId>
//	@Bean
//	public JdbcOperations jdbcTemplate(BasicDataSource dataSrouce) {
//		return new JdbcTemplate(dataSrouce);
//	}
	
}
