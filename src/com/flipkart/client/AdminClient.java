package com.flipkart.client;

import java.util.Date;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.service.CourseServiceInterface;
import com.flipkart.service.CourseServiceOperation;
import com.flipkart.service.UserServiceInterface;
import com.flipkart.service.UserServiceOperation;

/** 
 * @desc this class will hold functions for admin interaction
 * includes adminClient landing page
 * @author Anushka 
 */
public class AdminClient {

	// initializing the logger
	private static Logger logger = Logger.getLogger(UserClient.class);
	// initializing the scanner
	Scanner sc= new Scanner(System.in); 

	// admin client landing page
	public void adminClientPage(Admin admin){

		// initializing the instance userOperation to carry out user operations 
		UserServiceInterface userOperation= new UserServiceOperation();
		// initializing the instance courseOperation to carry out course operations 
		CourseServiceInterface courseOperation= new CourseServiceOperation();

		//begin variable listing
		User user;
		int userId;
		int profileOption;

		Date currentDate = new Date();
		// display contents of admin client landing page
		logger.info("Succesfully logged in as ADMIN on "+ currentDate);
		while(true) {
			// diplay menu list for admin
			logger.info("Welcome "+admin.getName()+" !");
			logger.info("Choose an option");
			logger.info("1. Create user");
			logger.info("2. Update user");
			logger.info("3. Delete user");
			logger.info("4. Add a new Course");
			logger.info("5. Delete Course");
			logger.info("6. Display users");
			logger.info("7. Logout");

			int choice= sc.nextInt();
			switch(choice) {
			// create a new user
			case 1:
				user= new User();

				logger.info("Enter UserId");
				userId=sc.nextInt();
				user.setUserId(userId);
				logger.info("Enter Username");
				user.setUserName(sc.next());
				logger.info("Enter Password");
				user.setUserPassword(sc.next());

				logger.info("Enter Profile ");
				logger.info("1. Student");
				logger.info("2. Professor");
				logger.info("3. Admin");
				profileOption=sc.nextInt();
				switch(profileOption){
				//if user is a student
				case 1:
					user.setRoleId(1);
					userOperation.createUser(user);
					Student student= new Student();
					student.setStudentId(userId);
					logger.info("Enter Name");
					student.setName(sc.next());
					logger.info("Enter gender");
					student.setGender(sc.next());
					logger.info("Enter Phone Number");
					student.setPhoneNumber(sc.nextInt());
					logger.info("Enter Semester");
					student.setSemester(sc.nextInt());
					logger.info("Enter Branch");
					student.setBranch(sc.next());
					student.setRegistrationStatus(false);
					logger.info("Enter Scholarship Allowance Percentage");
					student.setScholarshipPercentage(sc.nextInt());
					// create student
					userOperation.createStudent(student);
					break;

					// if user is a professor
				case 2:
					user.setRoleId(2);
					userOperation.createUser(user);
					Professor professor= new Professor();
					professor.setProfessorId(userId);
					logger.info("Enter Name");
					professor.setName(sc.next());
					logger.info("Enter gender");
					professor.setGender(sc.next());
					logger.info("Enter Phone Number");
					professor.setPhoneNumber(sc.nextInt());
					logger.info("Enter Designation");
					professor.setDesignation(sc.next());
					// create professor
					userOperation.createProfessor(professor);
					break;

					//if user is an admin
				case 3:
					user.setRoleId(3);
					userOperation.createUser(user);
					Admin newAdmin= new Admin();
					newAdmin.setAdminId(userId);
					logger.info("Enter Name");
					newAdmin.setName(sc.next());
					logger.info("Enter gender");
					newAdmin.setGender(sc.next());
					logger.info("Enter Phone Number");
					newAdmin.setPhoneNumber(sc.nextInt());
					// create admin
					userOperation.createAdmin(newAdmin);
					break;	
				}
				continue;

				// update an existing user
			case 2:
				user= new User();

				logger.info("Enter UserId");
				userId=sc.nextInt();
				user.setUserId(userId);
				logger.info("Enter Username");
				user.setUserName(sc.next());
				logger.info("Enter Password");
				user.setUserPassword(sc.next());
				logger.info("Enter Profile ");
				logger.info("1. Student");
				logger.info("2. Professor");
				logger.info("3. Admin");
				profileOption=sc.nextInt();
				switch(profileOption){
				//if user is student
				case 1:
					user.setRoleId(1);
					userOperation.updateUser(userId, user);
					Student student= new Student();
					student.setStudentId(userId);
					logger.info("Enter Name");
					student.setName(sc.next());
					logger.info("Enter gender");
					student.setGender(sc.next());
					logger.info("Enter Phone Number");
					student.setPhoneNumber(sc.nextInt());
					logger.info("Enter Semester");
					student.setSemester(sc.nextInt());
					logger.info("Enter Branch");
					student.setBranch(sc.next());
					student.setRegistrationStatus(false);
					logger.info("Enter Scholarship Allowance Percentage");
					student.setScholarshipPercentage(sc.nextInt());
					// update user
					userOperation.updateStudent(userId, student);
					break;
					//if user is a professor
				case 2:
					user.setRoleId(2);
					userOperation.updateUser(userId, user);
					Professor professor= new Professor();
					professor.setProfessorId(userId);
					logger.info("Enter Name");
					professor.setName(sc.next());
					logger.info("Enter gender");
					professor.setGender(sc.next());
					logger.info("Enter Phone Number");
					professor.setPhoneNumber(sc.nextInt());
					logger.info("Enter Designation");
					professor.setDesignation(sc.next());
					//update professor
					userOperation.updateProfessor(userId, professor);
					break;
					//if user is an admin
				case 3:
					user.setRoleId(3);
					userOperation.updateUser(userId, user);
					Admin newAdmin= new Admin();
					newAdmin.setAdminId(userId);
					logger.info("Enter Name");
					newAdmin.setName(sc.next());
					logger.info("Enter gender");
					newAdmin.setGender(sc.next());
					logger.info("Enter Phone Number");
					newAdmin.setPhoneNumber(sc.nextInt());
					//update admin
					userOperation.updateAdmin(userId, newAdmin);
					break;	
				}
				continue;

			// delete the user
			case 3:
				try{
					logger.info("Enter UserId of user to be deleted");
					userId= sc.nextInt();
					userOperation.deleteUser(userId,SQLConstantQueries.DELETE_USER );
					logger.info("Enter Profile ");
					logger.info("1. Student");
					logger.info("2. Professor");
					logger.info("3. Admin");
					profileOption=sc.nextInt();
					switch(profileOption){
					// if user is a student
					case 1:
						// delete student from student, registration and grade records
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_STUDENT );
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_STUDENT_REGISTER_COURSE);
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_STUDENT_GRADE );
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_STUDENT_REGISTRATION );
						logger.info("Student with Id= "+userId+" deleted !");
						break;
						// if user is a professor
					case 2:
						// delete professor from professor and cousre allotment records
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_PROFESSOR );
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_PROFESSOR_COURSE_ALLOTMENT );
						logger.info("Professor with Id= "+userId+" deleted !");
						break;
						// if user is admin
					case 3:
						// delete admin from admin records
						userOperation.deleteUser(userId,SQLConstantQueries.DELETE_ADMIN );
						logger.info("Admin with Id= "+userId+" deleted !");
						break;
					}
				}
				catch(UserNotFoundException e){
					logger.error(e.getMessage());				
					continue;		
				}
				continue;

				// insert a new course
			case 4:
				Course course= new Course();
				logger.info("Enter catalogId");
				course.setCatalogId(sc.nextInt());
				logger.info("Enter CousreId");
				course.setCourseId(sc.nextInt());
				logger.info("Enter Course Title");
				course.setCourseTitle(sc.next());
				logger.info("Enter Course Description ");
				course.setCourseDescription(sc.next());
				logger.info("Enter Semester");
				course.setSemester(sc.nextInt());
				logger.info("Enter Branch ");
				course.setBranch(sc.next());
				logger.info("Enter credits");
				course.setCredits(sc.nextInt());
				// course added in the database
				courseOperation.insertCourse(course);
				continue;

				// delete an existing course
			case 5:
				logger.info("Enter CourseId of course to be deleted");
				int courseId= sc.nextInt();
				// course deleted from database
				try {
					courseOperation.deleteCourse(courseId);
				} catch (CourseNotFoundException e) {
					logger.error(e.getMessage());
				}
				continue;

				// view user details
			case 6:
				while(true) {
					logger.info("1. View Student Details");
					logger.info("2. View Professor Details");
					logger.info("3. View Admin Details");
					logger.info("4. Go Back to Main Menu");
					int display= sc.nextInt();
					switch(display) {
					// view studennt details
					case 1:
						userOperation.displayStudents();
						continue;

						//view professor details
					case 2:
						userOperation.displayProfessors();
						continue;

						// view admin details
					case 3:
						userOperation.displayAdmins();
						continue;

						// back to main menu
					case 4: 
						break;
					}

					break;
				}
				continue;

				// log out as admin
			case 7:
				logger.info("Succesfully logged out as on "+ currentDate);
				break;

			}
			break;

		}

	}

}
