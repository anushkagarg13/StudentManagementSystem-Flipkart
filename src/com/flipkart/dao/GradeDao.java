package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;

/** 
 * @desc this interface is implemented by GradeDaoImplementaion class
 * @author Anushka
 */
public interface GradeDao {

	public List<Course> displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
}
