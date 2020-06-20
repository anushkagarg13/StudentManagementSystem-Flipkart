package com.flipkart.exception;

// user not found exception
public class UserNotFoundException extends Exception {
	public String getMessage() {
		String msg="No such user exists ! Verify UserID again ";
		return msg;
	}

}
