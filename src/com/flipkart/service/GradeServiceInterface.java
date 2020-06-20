package com.flipkart.service;

import com.flipkart.model.Student;

/** 
 * @desc this interface is implemented by GradeServiceOperation class
 * @author Anushka
 */
public interface GradeServiceInterface {
	
	public void displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);

}
