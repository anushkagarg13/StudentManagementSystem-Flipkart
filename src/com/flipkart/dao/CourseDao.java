package com.flipkart.dao;

import java.util.List;

import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.model.Course;
import com.flipkart.model.Student;


/** 
 * @desc this interface is implemented by courseDaoImplementation class
 * @author Anushka
 */
public interface CourseDao {
	public List<Course> displayCourses(Student student);
	public void insertCourse(Course course) ;
	public void deleteCourse(int courseId) throws CourseNotFoundException;
	public List<Course> displayCoursesProfessor();

}
