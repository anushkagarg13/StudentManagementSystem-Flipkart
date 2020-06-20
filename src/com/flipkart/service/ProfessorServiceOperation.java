package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;

/** 
 * @desc this class will hold functions for Professor service operation
 * examples include selectCourse(int courseId ,Professor professor),deselectCourse(int courseId, Professor professor)
 * @author Anushka
 */
public class ProfessorServiceOperation implements ProfessorServiceInterface{

	//initializing logger
	private static Logger logger = Logger.getLogger(ProfessorServiceOperation.class);

	ProfessorDao professorDao= new ProfessorDaoImpl();

	// select course by professsor
	public void selectCourse(int courseId ,Professor professor){
		professorDao.selectCourse(courseId, professor);
	}

	// deselect course by professor
	public void deselectCourse(int courseId, Professor professor){
		professorDao.deselectCourse(courseId, professor);
	}

	//display list of courses selected by professor
	public void displaySelectedCoursesProfessor(Professor professor){
		logger.info("********************************LIST OF SELECTED COURSES******************************");	
		logger.info("COURSE ID      COURSE TITLE                         NUMBER OF STUDENTS ENROLLED");
		List<Course> courses = professorDao.displaySelectedCoursesProfessor(professor);
		courses.forEach(course -> logger.info(course.getCourseId()+"               "+course.getCourseTitle()+"                               "+course.getStudentsEnrolled()));

		logger.info("*****************************************************************************************");
	}

	

}
