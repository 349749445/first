package com.test.demo.student.dao;

import com.test.demo.student.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    Student selectByPrimaryKeyAndLock(Integer id);
    
    int addAge(Integer id);
}