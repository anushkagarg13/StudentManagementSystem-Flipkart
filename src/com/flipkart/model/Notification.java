package com.flipkart.model;

public class Notification {
	private int registrationId;
	private int studentId;
	private double payableAmount;
	private int payModeId;
	private String timeStamp;
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public int getPayModeId() {
		return payModeId;
	}
	public void setPayModeId(int payModeId) {
		this.payModeId = payModeId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
