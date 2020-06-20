package com.flipkart.model;

public class Student extends User{
	
	private int StudentId;
	private String name;
	private String gender;
	private Long phoneNumber;
	private int semester;
	private String branch;
	private boolean registrationStatus;
	private int scholarshipPercentage;
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long i) {
		this.phoneNumber = i;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public boolean isRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public int getScholarshipPercentage() {
		return scholarshipPercentage;
	}
	public void setScholarshipPercentage(int scholarshipPercentage) {
		this.scholarshipPercentage = scholarshipPercentage;
	}
	
	

}
