package com.flipkart.service;

import com.flipkart.model.Student;

/** 
 * @desc this interface is implemented by StudentServiceOperation class
 * @author Anushka
 */
public interface StudentServiceInterface {
	
	public void addCourse(int courseId, Student student);
	public void dropCourse(int courseId,Student student);
	public void displaySelectedCourses(Student student);

}
