package com.flipkart.dao;
import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.utils.CloseConnection;
import com.flipkart.utils.DBUtil;

/** 
 * @desc this class will hold functions for course Dao Implementation
 * examples include displayCourses(Student student), insertCourse(Course course),displayCoursesProfessor(Student student)
 * @author Anushka
 */
public class CourseDaoImpl implements CourseDao,CloseConnection{

	//Initializing the logger
	private static Logger logger = Logger.getLogger(CourseDaoImpl.class);


	// provide list of courses available for a student to select
	// mapped with student's with branch and semester
	public List<Course> displayCourses(Student student) {

		//Establishing the connection
		Connection connection= DBUtil.getConnection();

		//Declaring prepared statement and executing query
		PreparedStatement stmt= null;
		try {
			int semester= student.getSemester();
			String branch= student.getBranch();
			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES);
			stmt.setInt(1, semester);
			stmt.setString(2,branch);

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of Course
			while(rs.next())
			{
				Course course = new Course();
				course.setBranch(branch);
				course.setSemester(semester);
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setCourseDescription(rs.getString("CourseDescription"));
				course.setCatalogId(rs.getInt("CatalogId"));
				course.setCredits(rs.getInt("Credits"));
				list.add(course);

			}

			return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
//		finally{
//			closeConnection(connection,stmt);
//		}
		
		return null;
		
	}

	// insert a new cousre in database against a course Id and catalog Id
	public void insertCourse(Course course)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		//Establishing the connection
		PreparedStatement stmt = null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_COURSE);
			int courseID= course.getCourseId();
			String title= course.getCourseTitle();
			String description= course.getCourseDescription();
			int semester= course.getSemester();
			String branch=course.getBranch();
			int catalogId=course.getCatalogId();
			int credits=course.getCredits();

			stmt.setInt(1, courseID);
			stmt.setInt(2, catalogId);
			stmt.setString(3, title);
			stmt.setString(4, description);
			stmt.setInt(5, credits);
			stmt.setInt(6, semester);
			stmt.setString(7,branch);


			//Executing query
			stmt.executeUpdate();
			logger.info("Course added!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		

	}

	// delete a cousre from course database using course Id	
	public void deleteCourse(int courseId) throws CourseNotFoundException{

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		//Establishing the connection
		PreparedStatement stmt = null;
		try {

			stmt=connection.prepareStatement(SQLConstantQueries.DELETE_COURSE+courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				logger.info("Course with courseId "+courseId+" deleted !");
				return;

			}
			throw new CourseNotFoundException();
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		
		

	}

	// provide list of courses available for professor to select to teach
	public List<Course> displayCoursesProfessor() {

		Connection connection= DBUtil.getConnection();

		//Declaring prepared statement and executing query
		PreparedStatement stmt= null;

		try {
			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES_PROFESSOR);
			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setBranch(rs.getString("Branch"));
				course.setSemester(rs.getInt("Semester"));
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setCourseDescription(rs.getString("CourseDescription"));
				list.add(course);

			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
//		finally{
//			closeConnection(connection,stmt);
//		}
		return null;
	}







}
