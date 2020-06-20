package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;

/** 
 * @desc this interface is implemented by  StudentDaoImplementation class
 * @author Anushka
 */
public interface StudentDao {
	
	public void addCourse(int courseId ,Student student) ;
	public void dropCourse(int courseId, Student student);
	public List<Course> displaySelectedCourses(Student student);

}
