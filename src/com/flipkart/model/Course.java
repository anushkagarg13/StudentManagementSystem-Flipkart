package com.flipkart.model;

public class Course {
	private int courseId;
	private String courseTitle;
	private String courseDescription;
	private String branch;
	private int credits;
	
	private int catalogId;
	private int semester;
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	private String time_stamp;
	private int studentsEnrolled;
	public int getStudentsEnrolled() {
		return studentsEnrolled;
	}
	public void setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	private String grade;
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	
	

}
