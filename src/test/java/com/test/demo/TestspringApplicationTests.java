package com.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import com.test.demo.bean.Person;
import com.test.demo.student.dao.StudentMapper;
import com.test.demo.student.model.Student;
import com.test.demo.student.service.StudentService;

@SpringBootTest
class TestspringApplicationTests {

	@Autowired
	Person person;

	@Autowired
	StudentService service;

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
	@Test
	void contextLoads() {
		Student student = service.getById(1);
		redisTemplate.opsForValue().set("student1", student);
	}

}
