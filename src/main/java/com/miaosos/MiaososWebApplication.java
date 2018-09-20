package com.miaosos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.miaosos.dao")
@EnableTransactionManagement
public class MiaososWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiaososWebApplication.class, args);
	}
}
