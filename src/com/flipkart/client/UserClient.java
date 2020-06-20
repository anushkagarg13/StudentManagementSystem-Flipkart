package com.flipkart.client;

import java.util.Scanner;


import org.apache.log4j.Logger;

import com.flipkart.exception.InvalidLoginException;
import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.service.UserServiceInterface;
import com.flipkart.service.UserServiceOperation;

/** 
 * @desc this class facilitates user interaction 
 * and user credential check
 * @author Anushka 
*/
public class UserClient {

	//initializing the logger
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	public static void main(String[] args) {
		
		//initializing the scanner
		Scanner sc= new Scanner(System.in); 

		// initializing the instance courseOperation to carry out user operations 
		UserServiceInterface userOperation= new UserServiceOperation();

		//user login landing page
		while(true) {
			logger.info("*******WELCOME TO STUDENT MANAGEMENT SYSTEM***********");
			logger.info("Enter your credentials");

			// fetching input for user credentials
			logger.info("Enter UserName");                          
			String username= sc.next();
			logger.info("Enter password");
			String password= sc.next();
			try{

				// validating the user credentials
				User checkedUser= userOperation.validateUser(username, password);
				int profile= checkedUser.getRoleId();
				int userId= checkedUser.getUserId();

				switch(profile) {
				// if user is a student
				case 1:
					// fetching student object from student table
					Student student = userOperation.fetchStudent(userId);
					StudentClient studentClient= new StudentClient();
					// redirecting to student client landing page
					studentClient.studentClientPage(student);
					continue;


				//if user is a professor
				case 2:
					//fetching professor object from professor table
					Professor professor= userOperation.fetchProfessor(userId);
					ProfessorClient professorClient= new ProfessorClient();
					//redirecting to professor client landing page
					professorClient.professorClientPage(professor);
					continue;

				//if user is an admin
				case 3:
					// fetching admin object from admin table
					Admin admin= userOperation.fetchAdmin(userId);
					AdminClient adminClient= new AdminClient();
					// redirecting to admin client landing page
					adminClient.adminClientPage(admin);
					continue;
				}
	
			}
			// catching the InvalidLoginException in catch block
			catch(InvalidLoginException e){
				logger.error(e.getMessage());				
				continue;		
			}

			break;
		}	
	}


}
