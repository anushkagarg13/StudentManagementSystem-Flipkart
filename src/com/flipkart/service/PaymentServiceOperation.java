package com.flipkart.service;

import com.flipkart.model.Student;

/** 
 * @desc this class will hold functions for Payment service operation
 * examples include calculatPayment(Student student)
 * @author Anushka
 */
public class PaymentServiceOperation implements PaymentServiceInterface{

	// calculate final payableAmount for student after deducting scholarship allowance
	public double calculatPayment(Student student) {
		int standardPayment= 10000;
		int scholarshipPercentage=student.getScholarshipPercentage();
		double payableAmount= standardPayment*(0.01*(100-scholarshipPercentage));
		return payableAmount;

	}



}
