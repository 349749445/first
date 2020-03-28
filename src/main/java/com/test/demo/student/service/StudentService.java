package com.test.demo.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.demo.student.dao.StudentMapper;
import com.test.demo.student.model.Student;

@Service
public class StudentService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	StudentMapper mapper;
	
	@Cacheable(value = "student", key="#id")
	public Student getById(Integer id) {
		logger.info("*****************************查询学生，ID："+id+"*********************************");
		Student student = mapper.selectByPrimaryKey(id);
		return student;
	}
}
