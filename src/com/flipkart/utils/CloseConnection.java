package com.flipkart.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.service.UserServiceOperation;

public interface CloseConnection {

	//initializing logger
	static Logger logger = Logger.getLogger(UserServiceOperation.class);

	//default function to close connections
	default public void closeConnection( Connection conn,PreparedStatement stmt){

		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			logger.error(se.getMessage());
		}


	}

}
