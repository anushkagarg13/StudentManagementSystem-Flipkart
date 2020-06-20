package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.model.Notification;
import com.flipkart.model.Student;

/** 
 * @desc this class will hold functions for Notification service operation
 * examples include showRegistrationReciept(Student student)
 * @author Anushka
 */
public class NotificationServiceOperation implements NotificationServiceInterface{

	//initializing logger
	private static Logger logger = Logger.getLogger(NotificationServiceOperation.class);
	RegistrationDao registrationDao= new RegistrationDaoImpl();

	// displays the registration summary of student
	public void showRegistrationReciept(Student student){
		Notification notification=registrationDao.showRegistrationReciept(student);
		logger.info("***************************REGISTRATION RECIEPT***********************");
		logger.info("Registration ID : "+notification.getRegistrationId());
		logger.info("Student ID : "+notification.getStudentId());
		logger.info("Name : "+student.getName());
		logger.info("PaymentAmount : "+notification.getPayableAmount());
		
		if(notification.getPayModeId()==1)
			logger.info("PaymentMode : 1, DEBIT_CARD");
		else if(notification.getPayModeId()==2)
			logger.info("PaymentMode : 2, E-WALLET");
		else if(notification.getPayModeId()==3)
			logger.info("PaymentMode : 3, NETBANKING");
		logger.info("Registration Date : "+notification.getTimeStamp());
		logger.info("***********************************************************************");


	}

}
