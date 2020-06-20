package com.flipkart.service;

import com.flipkart.model.Professor;

/** 
 * @desc this interface is implemented by ProfessorServiceOperation class
 * @author Anushka
 */
public interface ProfessorServiceInterface {
	public void selectCourse(int courseId ,Professor professor);
	public void deselectCourse(int courseId, Professor professor);
	public void displaySelectedCoursesProfessor(Professor professor);

}
