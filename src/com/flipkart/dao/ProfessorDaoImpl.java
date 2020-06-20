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
import com.flipkart.model.Professor;
import com.flipkart.model.User;
import com.flipkart.utils.CloseConnection;
import com.flipkart.utils.DBUtil;

/** 
 * @desc this class will hold functions for Professor Dao implementation
 * examples include selectCourse(int courseId ,Professor professor), deselectCourse(int courseId, Professor professor)
 * @author Anushka
 */
public class ProfessorDaoImpl implements ProfessorDao, CloseConnection{


	//Initializing the logger
	private static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);

	// select a course by professor to teach
	public void selectCourse(int courseId ,Professor professor)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_COURSE);

			int professorId= professor.getProfessorId();

			stmt.setInt(1, professorId);
			stmt.setInt(2, courseId);


			//Executing query
			stmt.executeUpdate();
			logger.info("Course with courseId="+courseId+" selected to teach!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		

	}

	// deselect a selected course by professor gainst courseId
	public void deselectCourse(int courseId, Professor professor) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt=connection.prepareStatement(SQLConstantQueries.DESELECT_COURSE);

			stmt.setInt(1, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				logger.info("Course deselected !");
				return;

			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		logger.info("Course not found !");

	}

	// display the list of courses selected by professor
	public List<Course> displaySelectedCoursesProfessor(Professor professor) {

		//Establishing the connection
		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_PROFESSOR_SELECTED_COURSES);
			stmt.setInt(1, professor.getProfessorId());

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setStudentsEnrolled(rs.getInt("NumberOfStudentsEnrolled"));

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
