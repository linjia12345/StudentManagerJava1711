package com.situ.student.service.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoImpl;
import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.util.Constant;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao studentDao = new StudentDaoImpl();

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public int add(Student student) {
		if(studentDao.checkName(student.getName())){
			return Constant.ADD_NAME_REPEAT;
		}else{
			
			int count = studentDao.add(student);
			if (count>0) {
				
				return Constant.ADD_SUCCESS;
			}
			return Constant.ADD_FAIL;
		}
		
		
	}

}
