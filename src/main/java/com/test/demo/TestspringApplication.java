package com.test.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value = "com.test.demo.**.dao")
@SpringBootApplication
@EnableCaching
public class TestspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestspringApplication.class, args);
	}

}
