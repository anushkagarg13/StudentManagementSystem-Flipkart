package com.flipkart.service;

import com.flipkart.exception.InvalidLoginException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.Admin;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;

/** 
 * @desc this interface is implemented by UserServiceOperation class
 * @author Anushka
 */
public interface UserServiceInterface {
	
	public User validateUser(String username, String password)throws InvalidLoginException;
	public Student fetchStudent(int studentId);
	 public Admin fetchAdmin(int adminId);
	 public Professor fetchProfessor(int professorId);
	 public void createUser(User user);
	 public void createStudent(Student student) ;
	 public void createProfessor(Professor professor);
	 public void createAdmin(Admin admin);
	 public void updateUser(int userId,User user);
	  public void updateStudent(int sudentId,Student student);
	  public void updateProfessor(int professsorId,Professor professor) ;
	  public void updateAdmin(int adminId,Admin admin) ;
	  public void deleteUser(int userId,String query) throws UserNotFoundException;
	 public void displayStudents();
	 public void displayProfessors();
	 public void displayAdmins() ;

}
