package com.hossein.hibernateCRUD.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hossein.hibernateCRUD.model.Student;
import com.hossein.hibernateCRUD.util.HibernateUtil;

public class StudentDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
}
