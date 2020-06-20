package com.flipkart.service;

import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.model.Course;
import com.flipkart.model.Student;

/** 
 * @desc this interface is implemented by CourseServiceOperation class
 * @author Anushka
 */
public interface CourseServiceInterface {

	public void displayCourses(Student student);
	public void insertCourse(Course course) ;
	public void deleteCourse(int courseId)throws CourseNotFoundException;
	public void displayCoursesProfessor();
}
