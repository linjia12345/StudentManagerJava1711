package com.situ.student.view;

import java.util.List;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.situ.student.controller.StudentController;
import com.situ.student.entity.Student;
import com.situ.student.util.Constant;

public class StudentView {
	private Scanner scanner = new Scanner(System.in);
	private StudentController studentController = new StudentController();

	public void showView() {
		while(true){
			System.out.println("--学生系统--");
			System.out.println("1.查询所有");
			System.out.println("2.添加");
			System.out.println("3.修改");
			System.out.println("4.删除");
			System.out.println("0.退出");
			System.out.println("请选择");
			int selected = scanner.nextInt();
			if(selected==0){
				System.out.println("退出程序");
				break;
			}
			switch (selected) {
			case 1:
                    findAll();
				break;
			case 2:
				add();

				break;
			case 3:

				break;
			case 4:

				break;
			case 0:

				break;
			default:
				break;
			}
		}
		

	}

	private void add() {
		while(true){
			System.out.println("请输入学生姓名:");
			String name = scanner.next();
			System.out.println("请输入年龄：");
			Integer age = scanner.nextInt();
			System.out.println("请输入性别：");
			String gender = scanner.next();
			System.out.println("请输入地址：");
			String address = scanner.next();
		int result = studentController.add(name,age,gender,address);
		switch(result){
		case Constant.ADD_SUCCESS:
		System.out.println("添加成功");
		break;
		case Constant.ADD_FAIL:
			System.out.println("添加失败");
			break;
		case Constant.ADD_NAME_REPEAT:
			System.out.println("重名");
			break;
			
		}
		System.out.println("是否继续添加学生：1：继续；2：退出");
		int quit = scanner.nextInt();
		if (quit==2) {
			break;
			
		}
		}
		
	}

	private void findAll() {
		System.out.println("StudentShow.findAll()");
		List<Student> list = studentController.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
}
