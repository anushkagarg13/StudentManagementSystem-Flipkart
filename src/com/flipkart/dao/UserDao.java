package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

/** 
 * @desc this interface is implemented by UserDaoImplementation class
 * @author Anushka
 */
public interface UserDao {
	
	//Initializing the logger
		static Logger logger = Logger.getLogger(UserDaoImpl.class);

	public User validateUser(String username, String pass);
	public Student fetchStudent(int studentId);
	 public Admin fetchAdmin(int adminId);
	 public Professor fetchProfessor(int professorId);
	 public void createUser(User user);
	 public void createStudent(Student student) ;
	 public void createProfessor(Professor professor);
	 public void createAdmin(Admin admin);
	  public void updateUser(int userId,User user);
	  public void updateStudent(int studentId,Student student);
	  public void updateProfessor(int professorId, Professor professor) ;
	  public void updateAdmin(int adminId,Admin admin) ;
	  public List<Student> displayStudents();
	  public List<Professor> displayProfessors();
	  public List<Admin> displayAdmins();
	  
	  default public void deleteUser(int userId, String query) throws UserNotFoundException {

			//Establishing the connection
			Connection connection = DBUtil.getConnection();
			try {

				//Establishing the connection
				PreparedStatement stmt = null;

				stmt=connection.prepareStatement(query);
				stmt.setInt(1, userId);
				//Executing query
				int rs = stmt.executeUpdate();
				if(rs>0){
					return;
				}
//				else 
//				throw new UserNotFoundException();

			} catch (SQLException ex) {
				logger.error(ex.getMessage());
			}
			
		}
	  

}
