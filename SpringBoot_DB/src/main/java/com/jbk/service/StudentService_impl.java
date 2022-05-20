package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbk.dao.StudentDao;
import com.jbk.entity.Student;
import com.jbk.model.Branch;
import com.jbk.model.Student_Branch;

@Service
public class StudentService_impl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Autowired
	private RestTemplate restTemplate;

	// StudentDao dao= new StudentDao_impl ();

	@Override
	public Student saveStudent(Student student) {
		String studentId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		student.setStudentId(studentId);
		Student std = dao.saveStudent(student);

		return std;
	}

	@Override
	public Student getStudentById(String studentId) {

		Student student = dao.getStudentById(studentId);

		return student;
	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> list = dao.getAllStudent();

		return list;
	}

	@Override
	public boolean deleteStudentById(String studentId) {

		boolean b = dao.deleteStudentById(studentId);
		return b;

	}

	@Override
	public Student updateStudent(Student student) {
		Student std = dao.updateStudent(student);
		return std;
	}

	@Override
	public Branch getBranchById(String branchId) {

		// call another MicroServices
		Branch branch = restTemplate.getForObject("http://localhost:8081/branch/getBranch/" + branchId, Branch.class);
		return branch;
	}

	@Override
	public Student_Branch getStudentWithBranch(String studentId) {
		Student_Branch student_Branch = new Student_Branch();

		Student student = getStudentById(studentId);
		if (student != null) {
			Branch branch = getBranchById(student.getBranchId());

			student_Branch.setStudent(student);
			student_Branch.setBranch(branch);

			return student_Branch;
		} else {
			return null;
		}
	}

	@Override
	public List<Student_Branch> getAllStudentWithBranch() {

		List<Student_Branch> student_Branch_list = new ArrayList<>();

		List<Student> studentList = getAllStudent();

		for (Student student : studentList) {
			Student_Branch student_Branch = new Student_Branch();

			Branch branch = getBranchById(student.getBranchId());

			student_Branch.setStudent(student);
			student_Branch.setBranch(branch);
			student_Branch_list.add(student_Branch);

		}

		return student_Branch_list;
	}

}
