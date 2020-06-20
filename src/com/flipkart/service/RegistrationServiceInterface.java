package com.flipkart.service;

import com.flipkart.model.Student;

/** 
 * @desc this interface is implemented by RegistrationServiceOperation class
 * @author Anushka
 */
public interface RegistrationServiceInterface {
public boolean checkCourseSelectionStatus(Student student);
	
	public void submitRegistration (Student student);
	
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);
	public void displayRegisteredStudentsInCourse(int courseId);


}
