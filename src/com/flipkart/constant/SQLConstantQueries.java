package com.flipkart.constant;

/** 
 * @desc this class will hold all the SQL Queries used in project
 * examples include VALIDATE_USER, DISPLAY_COURSES, ADD_COURSE, DROP_COURSE, INSERT_USER
 * @author Anushka
*/
public class SQLConstantQueries {
	
	public static final String VALIDATE_USER="SELECT UserID, RoleID FROM user WHERE Username=? AND Password=?";
	public static final String FETCH_STUDENT="SELECT * FROM student WHERE StudentID=?";
	public static final String FETCH_PROFESSOR="SELECT * FROM professor WHERE ProfessorID=?";
	public static final String FETCH_ADMIN="SELECT * FROM admin WHERE AdminID=?";
	
	public static final String DISPLAY_COURSES= "SELECT * FROM course WHERE Semester= ? AND Branch =?";
	
	public static final String ADD_COURSE="INSERT INTO register_course VALUES (?,?,false,CURRENT_TIMESTAMP)";
	
	public static final String DROP_COURSE="DELETE FROM register_course WHERE StudentID=? AND CourseID=?" ;
	
	public static final String VIEW_SELECTED_COURSES="SELECT course.CourseID, course.CourseTitle, course.Credits,  register_course.TimeStamp\r\n" + 
			"FROM course \r\n" + "INNER JOIN register_course \r\n" + "ON register_course.CourseID = course.CourseID\r\n" + "WHERE register_course.StudentID= ?";
	
	public static final String INSERT_USER="INSERT INTO user VALUES (?,?,?,?)";
	public static final String INSERT_STUDENT="INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";
	public static final String INSERT_PROFESSOR="INSERT INTO professor VALUES (?,?,?,?,?)";
	public static final String INSERT_ADMIN="INSERT INTO admin VALUES (?,?,?,?)";
	
	public static final String DELETE_USER="DELETE FROM user WHERE UserID=?" ;
	public static final String DELETE_STUDENT="DELETE FROM student WHERE StudentID=?" ;
	public static final String DELETE_ADMIN="DELETE FROM admin WHERE AdminID=?" ;
	public static final String DELETE_PROFESSOR="DELETE FROM professor WHERE ProfessorID=?" ;
	public static final String DELETE_STUDENT_REGISTER_COURSE="DELETE FROM register_course WHERE StudentID=?" ;
	public static final String DELETE_STUDENT_GRADE="DELETE grade WHERE StudentID=?" ;
	public static final String DELETE_STUDENT_REGISTRATION="DELETE FROM registration WHERE StudentID=?" ;
	public static final String DELETE_PROFESSOR_COURSE_ALLOTMENT="DELETE FROM course_inventory WHERE ProfessorID=?" ;
	
	public static final String UPDATE_USER="UPDATE user SET Username=?,Password=?, RoleID=? WHERE UserID=?";
	public static final String UPDATE_STUDENT="UPDATE student SET Name=?,Gender=?, PhoneNumber=?, Semester=?, Branch=?, StudentRegistrationStatus=?,ScholarshipPercentage=? WHERE StudentID=?";
	public static final String UPDATE_PROFESSOR="UPDATE professor SET Name=?,Gender=?, PhoneNumber=?,Designation=? WHERE ProfessorID=?";
	public static final String UPDATE_ADMIN="UPDATE admin SET Name=?,Gender=?, PhoneNumber=? WHERE AdminID=?";
	
	public static final String DISPLAY_STUDENTS="SELECT * FROM sms_flipkart.student";
	public static final String DISPLAY_PROFESSORS="SELECT * FROM professor";
	public static final String DISPLAY_ADMINS="SELECT * FROM admin";
	
	public static final String INSERT_COURSE="INSERT INTO course VALUES (?,?,?,?,?,?,?)";
	
	public static final String DELETE_COURSE="DELETE FROM course WHERE CourseID=" ;
	
	public static final String UPLOAD_GRADES="INSERT INTO grade VALUES (?,?,?,CURRENT_TIMESTAMP)";
	
	public static final String VIEW_GRADES="SELECT course.CourseID, course.CourseTitle,  grade.Grade \r\n" + "FROM course  \r\n" + "INNER JOIN grade  \r\n" + 
			"ON course.CourseID = grade.CourseID \r\n" + "WHERE grade.StudentID=?";
	
	public static final String NUMBER_OF_COURSES_SELECTED="SELECT count(CourseID) FROM register_course WHERE StudentID=?";

	public static final String UPDATE_REGISTARTION_STATUS="UPDATE student SET StudentRegistrationStatus= true WHERE StudentID=?";
	
	public static final String REGISTRATION_OF_COURSES= "UPDATE register_course SET CourseRegistrationStatus=1 WHERE STUDENTID=?";
	
	public static final String REGISTRATION_OF_COURSE= "INSERT INTO registration VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
	
	public static final String UPDATE_ENROLLED_STUDENTS_NUMBER="UPDATE course_inventory SET NumberOfStudentsEnrolled = NumberOfStudentsEnrolled +1 WHERE CourseID IN (SELECT CourseID FROM register_course WHERE StudentID=? AND CourseRegistrationStatus= true)";

	public static final String SUBMIT_REGISTRATION_DETAILS="INSERT INTO registration VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
	
	public static final String SHOW_REGISTRATION_RECIEPT= "SELECT * FROM registration WHERE StudentID=?";
	
	public static final String VIEW_ENROLLED_STUDENT_ID="SELECT StudentID FROM register_course WHERE CourseID=? AND CourseRegistrationStatus=1";

	public static final String DISPLAY_COURSES_PROFESSOR= "SELECT * FROM course" ;
	
	public static final String SELECT_COURSE="UPDATE course_inventory SET ProfessorID = ? WHERE CourseID=? ";
	
	public static final String DESELECT_COURSE="UPDATE course_inventory SET ProfessorID=0 WHERE CourseID=?" ;
	
	public static final String DISPLAY_PROFESSOR_SELECTED_COURSES="SELECT course.CourseID, course.CourseTitle, course_inventory.NumberOfStudentsEnrolled FROM course INNER JOIN course_inventory ON course.CourseID=course_inventory.CourseID WHERE ProfessorID=? ";
}
