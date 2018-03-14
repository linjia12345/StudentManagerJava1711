package com.situ.student.service;

import java.util.List;

import com.situ.student.entity.Student;

public interface IStudentService {

	List<Student> findAll();

	int add(Student student);



}
