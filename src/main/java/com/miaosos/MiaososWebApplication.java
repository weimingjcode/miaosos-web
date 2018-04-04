package com.miaosos;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.miaosos.dao")
public class MiaososWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiaososWebApplication.class, args);
	}
}
