package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Professor;

/** 
 * @desc this interface is implemented by ProfessorDaoImplementation class
 * @author Anushka
 */
public interface ProfessorDao {

	public void selectCourse(int courseId ,Professor professor);
	public void deselectCourse(int courseId, Professor professor);
	public List<Course> displaySelectedCoursesProfessor(Professor professor);

}
