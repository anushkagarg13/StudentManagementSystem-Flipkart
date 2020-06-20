package com.flipkart.service;
import java.util.List;


import org.apache.log4j.Logger;

import com.flipkart.dao.GradeDao;
import com.flipkart.dao.GradeDaoImpl;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;

/** 
 * @desc this class will hold functions for Grade service operation
 * examples include displayGrades(Student student ),uploadGrades(int studentId, int courseId, String grade)
 * @author Anushka
 */
public class GradeServiceOperation implements GradeServiceInterface{

	//initializing logger
	private static Logger logger = Logger.getLogger(GradeServiceOperation.class);

	GradeDao gradeDao= new GradeDaoImpl();

	// display grades for a student against courseId
	public void displayGrades(Student student ){
		logger.info("***********************************REPORT CARD******************************");	
		logger.info("COURSE ID      COURSE TITLE                     GRADE");
		List<Course> courses = gradeDao.displayGrades(student);

		courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseTitle()+"                       "+course.getGrade()));

		logger.info("*****************************************************************************");
	}

	// upload grades against a studentId and courseId by professor
	public void uploadGrades(int studentId, int courseId, String grade) {
		gradeDao.uploadGrades(studentId, courseId, grade);

	}

}
