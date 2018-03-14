package com.situ.student.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoImpl;
import com.situ.student.entity.Student;

public class StudentDaoImplTest {
	private IStudentDao studentDao;
	@Before
	public void before(){
		studentDao = new StudentDaoImpl();
		
	}
    @Test
	public void testAdd() {
    	Student student = new Student("古代",20,"男","青岛");
    	int result = studentDao.add(student);
    	if (result>0) {
    		System.out.println("添加成功");
			
		}else {
			System.out.println("添加失败");
		}
		
	}
    @Test
    public void testFindAll(){
    	List<Student> list = studentDao.findAll();
    	for (Student student : list) {
			System.out.println(student);
		}
    }

}
