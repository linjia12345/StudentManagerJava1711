package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;
import com.situ.student.util.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public int add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO student(NAME,age,gender,address)VALUES (?,?,?,?);";
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getGender());
			int result = preparedStatement.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(connection, preparedStatement);
		}
		
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id,name,age,gender,address from student;";
		List<Student> list = new ArrayList<Student>();
		
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Student student = new Student(id,name ,age,gender,address);
				list.add(student);
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(connection, preparedStatement,resultSet);
		}
		return list;
		
		
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT name from student where name =?;";
		
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(connection, preparedStatement,resultSet);
		}
		return false;
	}

	

}
