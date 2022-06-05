package com.hossein.hibernateCRUD;

import java.util.List;

import com.hossein.hibernateCRUD.dao.StudentDao;
import com.hossein.hibernateCRUD.model.Student;

public class App {
	
    public static void main( String[] args ) {
    	
    	StudentDao studentDao = new StudentDao();
    	
    	Student student = new Student("john", "doe", "john@gmail.com");
    	studentDao.saveStudent(student);
    	
    	student.setFirstName("jane");
    	studentDao.updateStudent(student);
    	
    	Student student2 = studentDao.getStudentById(student.getId());
    	System.out.println(student2);
    	
    	List<Student> students = studentDao.getAllStudents();
    	students.forEach(s -> System.out.println(s.getId()));
    	
    	studentDao.deleteStudent(student.getId());
    	
    }
}
