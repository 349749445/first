package com.test.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.student.model.Student;
import com.test.demo.student.service.StudentService;

@Controller
public class TestController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	StudentService service;
	
	@RequestMapping("/trade0001")
	public String trade0001(Map<String, Object> map) {
		logger.debug("****************trade0001******************");
		map.put("hello", "hello sh");
		return "index";
	}
	

	@RequestMapping("/trade0002")
	@ResponseBody
	public Student trade0002(int id) {
		logger.debug("****************trade0002******************");
		return service.getById(id);
	}
}
