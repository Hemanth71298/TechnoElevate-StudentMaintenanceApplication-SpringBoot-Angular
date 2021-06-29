package com.te.student.service;

import java.util.List;

import com.te.student.bean.StudentBean;

public interface StudentService {

	StudentBean getUser(int id);

	boolean deleteUserData(int id);

	List<StudentBean> getAllUser();

	boolean addUsers(StudentBean bean);

	boolean updateUser(StudentBean bean);

}
