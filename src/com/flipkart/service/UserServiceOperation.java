package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.InvalidLoginException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;

/** 
 * @desc this class will hold functions for user service operation
 * examples include validateUser(String username, String password),fetchStudent(int studentId)
 * @author Anushka
 */
public class UserServiceOperation implements UserServiceInterface {

	//initializing logger
	private static Logger logger = Logger.getLogger(UserServiceOperation.class);

	UserDao userDao= new UserDaoImpl();

	//validating users by checking their credentials
	public User validateUser(String username, String password) throws InvalidLoginException{
		User user= userDao.validateUser(username, password)	;
		if(user==null)
			throw new InvalidLoginException();
		return user;

	}

	//fetching student details from student databse against studentId
	public Student fetchStudent(int studentId){
		return userDao.fetchStudent(studentId);
	}

	//fetching admin details from admin databse against adminId
	public Admin fetchAdmin(int adminId){
		return userDao.fetchAdmin(adminId);
	}

	//fetching professor details from professor databse against professortId
	public Professor fetchProfessor(int professorId){
		return userDao.fetchProfessor(professorId);
	}

	//create new user
	public void createUser(User user){
		userDao.createUser(user);
	}

	//create new student
	public void createStudent(Student student) {
		userDao.createStudent(student);
	}

	//create new professor
	public void createProfessor(Professor professor){
		userDao.createProfessor(professor);
	}

	//create new admin
	public void createAdmin(Admin admin){
		userDao.createAdmin(admin);
	}

	// update user against userId
	public void updateUser(int userId,User user){
		userDao.updateUser(userId,user);
	}

	//update student against studentId
	public void updateStudent(int studentId,Student student){
		userDao.updateStudent(studentId,student);
	}

	//update professor against professorId
	public void updateProfessor(int professorId, Professor professor){
		userDao.updateProfessor(professorId,professor);
	}

	//update admin against adminId
	public void updateAdmin(int adminId,Admin admin){
		userDao.updateAdmin(adminId,admin);
	}

	//delete user against userId
	public void deleteUser(int userId, String query) throws UserNotFoundException {
		userDao.deleteUser(userId, query);
	}

	// display details of all students
	public void displayStudents() {
		logger.info("*********************************************LIST OF STUDENTS**********************************************");

		List<Student> students = userDao.displayStudents();

		students.stream().forEach(student -> {
			if(student.getGender().equals("female"))
				student.setName("Ms "+ student.getName() );
			else
				student.setName("Mr "+ student.getName() );
		});
		logger.info("STUDENT ID      NAME         PHONE NUMBER    BRANCH    SEMESTER    REGISTRATION STATUS      SCHOLARSHIP PERCENTAGE");
		for(Student student: students) {
			logger.info(student.getStudentId()+"         "+student.getName()+"          "+student.getPhoneNumber()+"        "+student.getBranch()+"        "+student.getSemester()+"                "+student.isRegistrationStatus()+"                      "+student.getScholarshipPercentage());
		}
		logger.info("*************************************************************************************************************");
	}

	// display details of all professors
	public void displayProfessors() {
		logger.info("****************************LIST OF PROFESSORS************************************");

		List<Professor> professors = userDao.displayProfessors();

		professors.stream().forEach(professor -> {
			if(professor.getGender().equals("female"))
				professor.setName("Ms "+ professor.getName() );
			else
				professor.setName("Mr "+ professor.getName() );
		});

		logger.info("PROFESSOR ID      NAME            PHONE NUMBER      DESIGNATION   ");
		for(Professor professor: professors) {
			logger.info(professor.getProfessorId()+"         "+professor.getName()+"          "+professor.getPhoneNumber()+"        "+professor.getDesignation());

		}
		logger.info("*******************************************************************************************");
	}

	// display details of all admins
	public void displayAdmins() {
		logger.info("**************LIST OF ADMINS****************");

		List<Admin> admins = userDao.displayAdmins();

		admins.stream().forEach(user -> {
			if(user.getGender().equals("female"))
				user.setName("Ms "+ user.getName() );
			else
				user.setName("Mr "+ user.getName() );
		});
		logger.info("USER ID      NAME           PHONE NUMBER      ");
		for(Admin admin: admins) {
			logger.info(admin.getAdminId()+"         "+admin.getName()+"          "+admin.getPhoneNumber());

		}
		logger.info("***********************************************");

	}



}
