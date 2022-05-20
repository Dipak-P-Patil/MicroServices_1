package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentDao {
	
	 //abstract class
	public Student saveStudent(Student student);
	public Student getStudentById(String studentId);
	public List<Student> getAllStudent();
	public boolean deleteStudentById(String studentId);
	public Student updateStudent(Student student);
	

}
