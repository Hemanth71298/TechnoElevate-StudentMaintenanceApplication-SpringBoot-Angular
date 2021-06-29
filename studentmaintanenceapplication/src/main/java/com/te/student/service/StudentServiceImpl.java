package com.te.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.student.bean.StudentBean;
import com.te.student.dao.StudentDAO;



public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;

	
	@Override

	public StudentBean getUser(int id) {

		return dao.getUser(id);
	}


	@Override
	
	public boolean deleteUserData(int id) {

		return dao.deleteUserData(id);
	}

	
	@Override
	
	public List<StudentBean> getAllUser() {

		return dao.getAllUser();
	}

	
	@Override
	
	public boolean addUsers(StudentBean bean) {

		return dao.addUser(bean);
	}

	
	@Override
	
	public boolean updateUser(StudentBean bean) {

		return dao.updateUser(bean);
	}



}
