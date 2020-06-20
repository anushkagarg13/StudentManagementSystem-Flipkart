package com.flipkart.client;

import java.util.Date;


import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Student;

import com.flipkart.service.CourseServiceInterface;
import com.flipkart.service.CourseServiceOperation;
import com.flipkart.service.GradeServiceInterface;
import com.flipkart.service.GradeServiceOperation;
import com.flipkart.service.NotificationServiceInterface;
import com.flipkart.service.NotificationServiceOperation;
import com.flipkart.service.PaymentServiceInterface;
import com.flipkart.service.PaymentServiceOperation;
import com.flipkart.service.RegistrationServiceInterface;
import com.flipkart.service.RegistrationServiceOperation;
import com.flipkart.service.StudentServiceInterface;
import com.flipkart.service.StudentServiceOperation;

/** 
 * @desc this class will hold functions for student interaction
 * includes Student Client landing page
 * @author Anushka 
 */
public class StudentClient {

	//initializing the logger
	private static Logger logger = Logger.getLogger(UserClient.class);

	//initializing the scanner
	Scanner sc= new Scanner(System.in); 

	// studentClient landing page
	public void studentClientPage(Student student) {

		// initializing the instance courseOperation to carry out course operations 
		CourseServiceInterface courseOperation= new CourseServiceOperation();
		// initializing the instance studentOperation to carry out student operations 
		StudentServiceInterface studentOperation= new StudentServiceOperation();

		// begin variable listing
		int choice;
		int courseId;
		Date currentDate= new Date();

		//student client landing page contents
		logger.info("Succesfully logged in as STUDENT on "+ currentDate);
		while(true) {
			logger.info("Welcome "+student.getName()+" !");

			// declaration of menu for student
			logger.info("Choose an option");
			logger.info("1. View All Courses");  
			logger.info("2. Add a course");
			logger.info("3. Drop a course");
			logger.info("4. View Selected Courses");
			logger.info("5. Submit Registration");
			logger.info("6. View Grades");
			logger.info("7. Logout");
			choice= sc.nextInt();

			switch(choice) {
			// display all available courses for a particular student
			case 1:
				courseOperation.displayCourses(student);
				continue;

			// add a course by student
			case 2:
				if(student.isRegistrationStatus()==false){
					logger.info("Enter CourseID of the Course to be added");
					courseId= sc.nextInt();
					studentOperation.addCourse(courseId, student);
				}
				else {
					logger.info("Registration already completed!");
				}
				continue;

			// drop a course by student
			case 3:
				if(student.isRegistrationStatus()==false){
					logger.info("Enter CourseID of the Course to be dropped");
					courseId= sc.nextInt();
					studentOperation.dropCourse(courseId, student);
				}
				else {
					logger.info("Registration already completed!");
				}
				continue;

			// display all the courses that student has selected so far with Registration status
			case 4:
				studentOperation.displaySelectedCourses(student);
				continue;

			// submit registration
			case 5:
				RegistrationServiceInterface registrationOperation= new RegistrationServiceOperation();

				// if student has already completed registration
				if(student.isRegistrationStatus()) {
					logger.info("Registration already completed !" );
					logger.info("1. Show Registration Reciept");
					logger.info("2. Back to main menu");
					int option= sc.nextInt();
					switch(option){

					// displaying course registration receipt
					case 1:
						NotificationServiceInterface notificationOperation= new NotificationServiceOperation();
						notificationOperation.showRegistrationReciept(student);
						break;

						// back to main menu
					case 2:
						break;
					}
				}

				// if number of courses selected by students is <4 or >4
				else if(registrationOperation.checkCourseSelectionStatus(student)==false) {
					logger.info("Please select EXACTLY 4 courses !");
				}

				// if number of courses selected is exactly 4 and  courses are available
				else {
					logger.info("Note: Once registered, you won't be able to alter your selections.");

					// listing further actions
					logger.info("1. Submit Registration");
					logger.info("2. Back to main menu");
					int option= sc.nextInt();
					switch(option) {

					// continuing with registration
					// calculating and displaying payment amount
					case 1:
						PaymentServiceInterface paymentOperation= new PaymentServiceOperation();
						double payableAmount= paymentOperation.calculatPayment(student);
						logger.info("************************PAYMENT DETAILS******************************");
						logger.info("Total payment amount: Rs 10000.00");
						logger.info("Scholarship Perectage: "+student.getScholarshipPercentage());
						logger.info("Total payable fees: Rs "+payableAmount);            // total payable amount after deduction of scholarship allowance
						logger.info("*********************************************************************");

						
						// listing further actions
						
						logger.info("1. Pay Fees");
						logger.info("2. Back to main menu");
						
						int option2= sc.nextInt();
						switch(option2) {

						//choosing mode of payment
						case 1:
							logger.info("************************PAYMENT GATEWAY******************************");
							logger.info("Choose mode of payment");
							logger.info("1. Debit Card");
							logger.info("2. E- Wallet");
							logger.info("3. Netbanking");
							logger.info("*********************************************************************");
							int paymentOption= sc.nextInt();

							// submitting registration
							registrationOperation.submitRegistration (student); 
							currentDate= new Date();
							switch(paymentOption) {
							// fees submission using debit card
							case 1:
								logger.info("Registration succesfully completed on "+currentDate+" using DEBIT_CARD");
								break;
								// fees submission using e-wallet
							case 2:
								logger.info("Registration succesfully completed on "+currentDate+" using E_WALLET");
								break;
								// fees submission using netbanking
							case 3:
								logger.info("Registration succesfully completed on "+currentDate+" using NETBANKING");
								break;

							}

							// registration details stored in database
							registrationOperation.generateRegistrationReciept(student, payableAmount, paymentOption);
							// listing further actions
							logger.info("1. Show Registration Reciept");
							logger.info("2. Back to main menu");
							int option3= sc.nextInt();
							switch(option3){
							// fetching and displaying registration
							case 1:
								NotificationServiceInterface notificationOperation= new NotificationServiceOperation();
								notificationOperation.showRegistrationReciept(student);
								break;

							case 2:
								break;
							}
							break;
						case 2:
							break;
						}
						break;

					case 2:
						break;


					}
				}
				continue;

			// display grades for student
			case 6: 
				GradeServiceInterface gradeOperation= new GradeServiceOperation();
				gradeOperation.displayGrades(student);
				continue;

			// log out as a student
			case 7:
				currentDate = new Date();
				logger.info("Succesfully logged out as on "+ currentDate);
				break;

			}
			break;

		}
	}

}