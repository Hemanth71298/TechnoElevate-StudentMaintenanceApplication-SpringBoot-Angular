package com.te.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.student.bean.StudentBean;


@Repository
public abstract class StudentDAOImpl implements StudentDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	
	public StudentBean getUser(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Student_db");
		EntityManager entityManager = factory.createEntityManager();

		StudentBean studentBean = entityManager.find(StudentBean.class, id);
		return studentBean;

	}

	@Override
	
	public boolean removeUserData(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			StudentBean bean = entityManager.find(StudentBean.class, id);
			if (bean != null) {
				entityManager.remove(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBean> getAllUser() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager entityManager = factory.createEntityManager();

		String query = " from StudentBean ";
		Query query2 = entityManager.createQuery(query);

		List<StudentBean> allUserData = query2.getResultList();

		return allUserData;

	}

	@Override
	public boolean insertUser(StudentBean bean) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			transaction.rollback();
			isAdded = false;
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean updateUser(StudentBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isUpdated = false;

		try {
			transaction.begin();
			StudentBean info = manager.find(StudentBean.class, bean.getUserid());
			if (bean.getName() != null && bean.getName() != "") {
				 info.setName(bean.getName());
			}
			if (bean.getEmail() != null) {
				 info.setEmail(bean.getEmail());
			}

			if (bean.getMarks() !=0 && bean.getMarks() !=0 ) {
				info.setMarks(bean.getMarks());
			}
			if(bean.getGrade() != null && bean.getGrade() !="") {
				info.setGrade(bean.getGrade());
			}

			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isUpdated;
	}



}
