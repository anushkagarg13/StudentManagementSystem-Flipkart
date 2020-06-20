package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
	public String getMessage() {
		String msg="No such user exists ! Verify UserID again ";
		return msg;
	}

}
