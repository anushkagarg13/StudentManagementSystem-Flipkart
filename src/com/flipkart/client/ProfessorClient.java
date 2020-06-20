package com.flipkart.client;

import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Professor;
import com.flipkart.service.CourseServiceInterface;
import com.flipkart.service.CourseServiceOperation;
import com.flipkart.service.GradeServiceInterface;
import com.flipkart.service.GradeServiceOperation;
import com.flipkart.service.ProfessorServiceInterface;
import com.flipkart.service.ProfessorServiceOperation;
import com.flipkart.service.RegistrationServiceInterface;
import com.flipkart.service.RegistrationServiceOperation;

/** 
 * @desc this class will hold functions for professor interaction
 * includes Professor Client landing page
 * @author Anushka 
*/
public class ProfessorClient {

	// initializing the logger
	private static Logger logger = Logger.getLogger(UserClient.class);

	// initializing the scanner
	Scanner sc= new Scanner(System.in); 
	
	// professor client landing page
	public void professorClientPage(Professor professor) {

		int courseId;

		// initializing the instance courseOperation to carry out course operations 
		CourseServiceInterface courseOperation= new CourseServiceOperation();
		// initializing the instance professorOperation to carry out professor operations 
		ProfessorServiceInterface professorOperation= new ProfessorServiceOperation();

		Date currentDate = new Date();
		// professor client page contents
		logger.info("Succesfully logged in as PROFESSOR on "+ currentDate);
		while(true) {
			logger.info("Welcome "+professor.getName()+" !");

			// display menu list for professor
			logger.info("Choose an option"); 
			logger.info("1. View Courses to teach");
			logger.info("2. Select a course");
			logger.info("3. Deselect a course");
			logger.info("4. View Selected Courses");
			logger.info("5. Upload Grades");
			logger.info("6. Logout");

			int choice= sc.nextInt();

			switch(choice) {
			// display all the courses available for professor to teach
			case 1:
				courseOperation.displayCoursesProfessor();
				continue;

			// select a course to teach
			case 2:
				logger.info("Enter CourseID of the Course to be selected");
				courseId= sc.nextInt();
				professorOperation.selectCourse(courseId, professor);
				continue;

			// deselect a course
			case 3:
				logger.info("Enter CourseID of the Course to be deselected");
				courseId= sc.nextInt();
				professorOperation.deselectCourse(courseId, professor);
				continue;

			// display list of courses selected by professor to teach
			case 4:
				professorOperation.displaySelectedCoursesProfessor(professor);
				continue;

			// upload grades 
			case 5:
				RegistrationServiceInterface registartionOperation= new RegistrationServiceOperation();
				logger.info("Enter the CourseID to upload grades");
				courseId= sc.nextInt();
				// shows the list of students enrolled in particular course
				registartionOperation.displayRegisteredStudentsInCourse(courseId);
				logger.info("Enter the StudentID to upload grades");
				int studentId= sc.nextInt();
				logger.info("Enter the grade");
				String grade= sc.next();
				// grade submission
				GradeServiceInterface gradeOperation= new GradeServiceOperation();
				gradeOperation.uploadGrades(studentId, courseId, grade);
				continue;

			// log out as a professor
			case 6:
				currentDate = new Date();
				logger.info("Succesfully logged out as on "+ currentDate);
				break;

			}
			break;

		}
	}

}
