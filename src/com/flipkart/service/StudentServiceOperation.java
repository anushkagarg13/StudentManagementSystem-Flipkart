package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.model.Course;
import com.flipkart.model.Student;

/** 
 * @desc this class will hold functions for Student service operation
 * examples include addCourse(int courseId, Student student),dropCourse(int courseId,Student student)
 * @author Anushka
 */
public class StudentServiceOperation implements StudentServiceInterface{

	//initializing logger
	private static Logger logger = Logger.getLogger(StudentServiceOperation.class);

	StudentDao studentDao= new StudentDaoImpl();

	// add course by student against courseId
	public void addCourse(int courseId, Student student) {
		studentDao.addCourse(courseId, student);
	}

	// drop course by student against courseId
	public void dropCourse(int courseId,Student student) {
		studentDao.dropCourse(courseId, student);
	}

	//display courses selected by student
	public void displaySelectedCourses(Student student) {
		logger.info("***********************************LIST OF SELECTED COURSES******************************");	
		logger.info("COURSE ID      COURSE TITLE               CREDITS           TIME STAMP             ");
		List<Course> courses = studentDao.displaySelectedCourses(student);
		courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseTitle()+"                    "+course.getCredits()+"              "+course.getTime_stamp()));
		boolean status= student.isRegistrationStatus();
		if(status)
			logger.info("++++++++++++++++++++++++++++REGISTRATION STATUS: COMPLETED ++++++++++++++++++++++++++++");
		else
			logger.info("++++++++++++++++++++++++++++REGISTRATION STATUS: PENDING ++++++++++++++++++++++++++++++");

	}

}
