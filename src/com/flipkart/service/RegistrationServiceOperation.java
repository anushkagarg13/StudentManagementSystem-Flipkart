package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.model.Student;

/** 
 * @desc this class will hold functions for Registration service operation
 * examples include submitRegistration (Student student),displayRegisteredStudentsInCourse(int courseId)
 * @author Anushka
 */
public class RegistrationServiceOperation implements RegistrationServiceInterface {

	//initializing logger
	private static Logger logger = Logger.getLogger(RegistrationServiceOperation.class);

	RegistrationDao registrationDao= new RegistrationDaoImpl();

	// checks if student has selected exactly  4 courses or not
	public boolean checkCourseSelectionStatus(Student student) {
		return registrationDao.numberOfCoursesSelected(student);
	}

	// submit registration for student
	public void submitRegistration (Student student) {
		registrationDao.submitRegistration (student);
	}

	// generate student registration details and store them in database
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId){
		registrationDao.generateRegistrationReciept(student, payableAmount, payModeId);
	}

	// display studentID of students enrolled in a course
	public void displayRegisteredStudentsInCourse(int courseId){
		logger.info("*********************STUDENTS ENROLLED******************************");	
		logger.info("STUDENT ID");
		List<Integer> students = registrationDao.displayRegisteredStudentsInCourse(courseId);
		students.forEach(student -> logger.info(student));

	}

}
