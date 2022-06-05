package com.hossein.hibernateCRUD.dao;

import java.util.List;

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
	
	public Student getStudentById(Long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}
	
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
		
			students = session.createQuery("from Student").list();

			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}
	
	public void deleteStudent(Long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			session.delete(student);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
}
