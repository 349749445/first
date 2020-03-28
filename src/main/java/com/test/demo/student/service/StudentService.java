package com.test.demo.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	

	@Transactional
	public int update(Student student) throws RuntimeException {
		logger.info("*****************************更新学生，ID："+student.getId()+"*********************************");
		int result = mapper.updateByPrimaryKey(student);
		return result;
	}

	@Transactional
	public int addAge(Integer id) throws RuntimeException, InterruptedException {
		logger.info("*****************************addNo，ID："+id+"*********************************");
		int result = 0;
		//测试查询时获取排它锁的并发
		Student student = mapper.selectByPrimaryKeyAndLock(id);
		if(student.getAge() == 0) {
			Thread.sleep(3000l);
			result = mapper.addAge(id);
		} else {
			logger.info("*****************************age不等于0********************");
		}
		return result;
	}
}
