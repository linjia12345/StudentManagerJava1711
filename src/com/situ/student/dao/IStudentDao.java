package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Student;

public interface IStudentDao {
    public abstract int add(Student student);
    public abstract int delete(Integer id);
    public abstract int update(Student student);
    public abstract Student findById(Integer id);
    public abstract List<Student> findAll();
	public abstract boolean checkName(String name);
    
    
}
