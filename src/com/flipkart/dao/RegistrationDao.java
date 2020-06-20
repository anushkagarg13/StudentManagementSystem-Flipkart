package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Notification;
import com.flipkart.model.Student;

/** 
 * @desc this interface is implemented by RegistrationDaoImplementaion class
 * @author Anushka
 */
public interface RegistrationDao {
	public boolean numberOfCoursesSelected (Student student);
	public void submitRegistration (Student student);
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);
	public Notification showRegistrationReciept(Student student);
	public List<Integer> displayRegisteredStudentsInCourse(int courseId);

}
