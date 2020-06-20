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
 * @desc this class will hold functions for Grade Dao implementation
 * examples include displayGrades(Student student), uploadGrades(int studentId, int courseId, String grade)
 * @author Anushka
 */
public class GradeDaoImpl implements GradeDao, CloseConnection{
	//Initializing the logger
	private static Logger logger = Logger.getLogger(GradeDaoImpl.class);


	// fetch grades of students against courseId and studentId
	public List<Course> displayGrades(Student student) {

		//Establishing the connection
		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			//Declaring prepared statement and executing query
			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_GRADES);
			stmt.setInt(1, student.getStudentId());

			ResultSet rs = stmt.executeQuery();
			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();

				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setGrade(rs.getString("Grade"));

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

	// upload grades against a studentId and courseId
	public void uploadGrades(int studentId, int courseId, String grade) {
		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt=null;

		try {
			//Declaring prepared statement and executing query
			 stmt = connection.prepareStatement(SQLConstantQueries.UPLOAD_GRADES);

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			stmt.setString(3, grade);

			//Executing query
			stmt.executeUpdate();
			logger.info("Grade uploaded");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		

	}

}
