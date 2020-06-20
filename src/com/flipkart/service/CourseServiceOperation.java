package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

/** 
 * @desc this class will hold functions for Course service operation
 * examples include displayCourses(Student student),insertCourse(Course course)
 * @author Anushka
 */
public class CourseServiceOperation implements CourseServiceInterface{

	//initializing logger
	private static Logger logger = Logger.getLogger(CourseServiceOperation.class);

	CourseDao courseDao= new CourseDaoImpl();

	// display list of available courses for student 
	public void displayCourses(Student student) {
		logger.info("****************************************LIST OF AVAILABLE COURSES*****************************************1****");
		logger.info("COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION                         CREDITS         ");
		List<Course> courses = courseDao.displayCourses(student);
		for(Course course:courses) {
			if(course.getStudentsEnrolled()<10) {
				logger.info(course.getCourseId()+"               "+course.getCourseTitle()+"               "+course.getCourseDescription()+"                  "+course.getCredits());
			}
		}
		logger.info("*************************************************************************************************************");
	}

	// insert a new course in database
	public void insertCourse(Course course) {
		courseDao.insertCourse(course);
	}

	//delete an existing course
	public void deleteCourse(int courseId)throws CourseNotFoundException{
		courseDao.deleteCourse(courseId);
	}

	//display available courses for professor to select
	public void displayCoursesProfessor() {
		logger.info("****************************LIST OF AVAILABLE COURSES************************************");
		logger.info("COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION             ");
		List<Course> courses = courseDao.displayCoursesProfessor();
		courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseTitle()+"               "+course.getCourseDescription()));

		logger.info("******************************************************************************************");

	}



}
