package com.flipkart.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.model.*;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.utils.CloseConnection;
import com.flipkart.utils.DBUtil;

/** 
 * @desc this class will hold functions for User Dao Implementation
 * examples include 
 * @author Anushka
 */
public class UserDaoImpl implements UserDao,CloseConnection {
	//Initializing the logger
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	// validates the user by checking its credentials
	public User validateUser(String username, String pass) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			//Declaring prepared statement
			stmt=connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				User checkeduser = new User();
				checkeduser.setUserId( rs.getInt("UserID") );
				checkeduser.setRoleId(rs.getInt("RoleID"));

				return checkeduser;
			}

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
//		
		return null;
	}

	// fetch student from student database against studentId
	public Student fetchStudent(int studentId){

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt=connection.prepareStatement(SQLConstantQueries.FETCH_STUDENT);
			stmt.setInt(1, studentId);

			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				Student student= new Student();
				student.setStudentId(studentId);
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getLong("PhoneNumber"));
				student.setGender(rs.getString("Gender"));
				student.setSemester(rs.getInt("Semester"));
				student.setBranch(rs.getString("Branch"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));
				return student;
			}


		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
//		
		return null;

	}

	// fetch admin from admin database against admin Id
	public Admin fetchAdmin(int adminId){

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement
			stmt = null;
			stmt=connection.prepareStatement(SQLConstantQueries.FETCH_ADMIN);
			stmt.setInt(1, adminId);

			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				Admin admin= new Admin();
				admin.setAdminId(adminId);
				admin.setName(rs.getString("Name"));
				admin.setPhoneNumber(rs.getLong("PhoneNumber"));
				admin.setGender(rs.getString("Gender"));

				return admin;
			}


		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
//		
		return null;

	}

	// fetch professor from professor database against professorId
	public Professor fetchProfessor(int professorId){

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement
			stmt = null;
			stmt=connection.prepareStatement(SQLConstantQueries.FETCH_PROFESSOR);
			stmt.setInt(1, professorId);

			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				Professor professor= new Professor();
				professor.setProfessorId(professorId);
				professor.setName(rs.getString("Name"));
				professor.setPhoneNumber(rs.getLong("PhoneNumber"));
				professor.setGender(rs.getString("Gender"));
				professor.setDesignation(rs.getString("Designation"));

				return professor;
			}


		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
//		
		return null;

	}

	// create a new user
	public void createUser(User user)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_USER);
			int userId= user.getUserId();
			String username=user.getUserName();
			String password= user.getUserPassword();
			int roleId= user.getRoleId();

			stmt.setInt(1, userId);
			stmt.setString(2, username);
			stmt.setString(3, password);

			stmt.setInt(4, roleId);

			//Executing query
			stmt.executeUpdate();


		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		

	}

	// create a new student
	public void createStudent(Student student)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_STUDENT);
			int studentId= student.getStudentId();

			String name= student.getName();
			long phoneNo= student.getPhoneNumber();
			int semester= student.getSemester();
			String branch=student.getBranch();

			String gender= student.getGender();
			Boolean isRegistrationComplete= student.isRegistrationStatus();

			int ScholarshipAllowancePercentage= student.getScholarshipPercentage();

			stmt.setInt(1, studentId);
			stmt.setString(2, name);
			stmt.setString(3, gender);

			stmt.setLong(4, phoneNo);
			stmt.setInt(5, semester);
			stmt.setString(6, branch);

			stmt.setBoolean(7,isRegistrationComplete);

			stmt.setInt(8,ScholarshipAllowancePercentage);


			//Executing query
			stmt.executeUpdate();
			logger.info("Student"+" added!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());

		}
		

	}

	//create a new professor
	public void createProfessor(Professor professor)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_PROFESSOR);
			int professorId= professor.getProfessorId();

			String name= professor.getName();
			long phoneNo= professor.getPhoneNumber();
			String gender= professor.getGender();
			String designation= professor.getDesignation();

			stmt.setInt(1, professorId);
			stmt.setString(2, name);
			stmt.setString(3, gender);
			stmt.setLong(4, phoneNo);
			stmt.setString(5, designation);

			//Executing query
			stmt.executeUpdate();
			logger.info("Professor"+" added!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		

	}

	// create a new admin
	public void createAdmin(Admin admin)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_ADMIN);
			int adminId= admin.getAdminId();
			String name= admin.getName();
			long phoneNo= admin.getPhoneNumber();
			String gender= admin.getGender();

			stmt.setInt(1, adminId);
			stmt.setString(2, name);
			stmt.setString(3, gender);
			stmt.setLong(4, phoneNo);

			//Executing query
			stmt.executeUpdate();
			logger.info("Admin"+" added!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		

	}

	// update an user
	public void updateUser(int userID,User user) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_USER);
			int userId= user.getUserId();
			String username=user.getUserName();
			String password= user.getUserPassword();
			int roleId= user.getRoleId();
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, roleId);
			stmt.setInt(4, userId);

			//Executing query
			stmt.executeUpdate();

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
	}

	// update a student against studentId
	public void updateStudent(int studentID,Student student)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_STUDENT);
			int studentId= student.getStudentId();
			String name= student.getName();
			long phoneNo= student.getPhoneNumber();
			int semester= student.getSemester();
			String branch=student.getBranch();
			String gender= student.getGender();
			Boolean isRegistrationComplete= student.isRegistrationStatus();
			int ScholarshipAllowancePercentage= student.getScholarshipPercentage();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setInt(4, semester);
			stmt.setString(5, branch);
			stmt.setBoolean(6,isRegistrationComplete);
			stmt.setInt(7,ScholarshipAllowancePercentage);
			stmt.setInt(8, studentId);

			//Executing query
			stmt.executeUpdate();
			logger.info("Student details updated !");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
	}

	// update Professor against professorId
	public void updateProfessor(int professorID,Professor professor)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_PROFESSOR);
			int professorId= professor.getProfessorId();

			String name= professor.getName();
			long phoneNo= professor.getPhoneNumber();
			String gender= professor.getGender();
			String designation= professor.getDesignation();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setString(4, designation);
			stmt.setInt(5, professorId);

			//Executing query
			stmt.executeUpdate();
			logger.info("Professor details updated !");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
	}

	// update admin against adminId
	public void updateAdmin(int adminID,Admin admin)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_ADMIN);
			int adminId= admin.getAdminId();
			String name= admin.getName();
			long phoneNo= admin.getPhoneNumber();
			String gender= admin.getGender();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setInt(4, adminId);

			//Executing query
			stmt.executeUpdate();
			logger.info("Admin details updated !");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		
	}

	// provides details of all students
	public List<Student> displayStudents() {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt= connection.prepareStatement(SQLConstantQueries. DISPLAY_STUDENTS);

			ResultSet rs = stmt.executeQuery();

			List<Student> list= new ArrayList<Student>();

			//Creating ArrayList of student
			while(rs.next())
			{
				Student student= new Student();
				student.setStudentId(rs.getInt("StudentID"));
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getLong("PhoneNumber"));
				student.setGender(rs.getString("Gender"));
				student.setBranch(rs.getString("Branch"));
				student.setSemester(rs.getInt("Semester"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));
				
				list.add(student);
				                    
			}

			//returning list of student
			return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		return null;
	}

	// provides details of all professors
	public List<Professor> displayProfessors() {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries. DISPLAY_PROFESSORS);

			ResultSet rs = stmt.executeQuery();

			List<Professor> list= new ArrayList<Professor>();

			//Creating ArrayList of professor
			while(rs.next())
			{
				Professor professor= new Professor();
				professor.setProfessorId(rs.getInt("ProfessorID"));
				professor.setName(rs.getString("Name"));
				professor.setPhoneNumber(rs.getLong("PhoneNumber"));
				professor.setGender(rs.getString("Gender"));
				professor.setDesignation(rs.getString("Designation"));

				list.add(professor);
					                         
			}

			//returning list of professors
			return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		return null;
	}

	// provide details of all admins
	public List<Admin> displayAdmins() {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			stmt= connection.prepareStatement(SQLConstantQueries. DISPLAY_ADMINS);

			ResultSet rs = stmt.executeQuery();

			List<Admin> list= new ArrayList<Admin>();

			//Creating ArrayList of admin
			while(rs.next())
			{
				Admin admin= new Admin();
				admin.setAdminId(rs.getInt("AdminID"));
				admin.setName(rs.getString("Name"));
				admin.setPhoneNumber(rs.getLong("PhoneNumber"));
				admin.setGender(rs.getString("Gender"));

				list.add(admin);
					                         
			}

			//returning list of admins
			return list;
		}
		catch(SQLException ex) {
			logger.error(ex.getMessage());
		}
		
		return null;
	}

	





}
