package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.CloseConnection;
import com.flipkart.utils.DBUtil;

/** 
 * @desc this class will hold functions for Student Dao Implentation
 * examples include 
 * @author Anushka
 */
public class StudentDaoImpl implements StudentDao,CloseConnection{

	//Initializing the logger
	private static Logger logger = Logger.getLogger(StudentDaoImpl.class);

	// add a course by student
	public void addCourse(int courseId ,Student student)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.ADD_COURSE);

			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);

			//Executing query
			stmt.executeUpdate();
			logger.info("Course with courseId="+courseId+" added!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		

	}

	// drop a course by student against a courseID
	public void dropCourse(int courseId, Student student) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
		try {

			//Establishing the connection
			stmt=connection.prepareStatement(SQLConstantQueries.DROP_COURSE);
			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				logger.info("Course dropped !");
				return;

			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		logger.info("Course not found !");

	}

	// display list of courses selected by student
	public List<Course> displaySelectedCourses(Student student) {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_SELECTED_COURSES);
			stmt.setInt(1, student.getStudentId());


			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setCredits(rs.getInt("Credits"));
				course.setTime_stamp(rs.getString("TimeStamp"));
				list.add(course);

			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		return null;
	}


}
