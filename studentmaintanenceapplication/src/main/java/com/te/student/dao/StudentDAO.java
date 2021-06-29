package com.te.student.dao;

import java.util.List;

import com.te.student.bean.StudentBean;

public interface StudentDAO {

	StudentBean getUser(int id);

	boolean removeUserData(int id);

	List<StudentBean> getAllUser();

	

	boolean updateUser(StudentBean bean);

	

	boolean insertStudent(StudentBean bean);

	boolean insertUser(StudentBean bean);

	

	

	

}
