package com.pabebestore.inventory.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DefaultConnectionDAO {
	
	private String host;
	private String user;
	private String password;
	private String databaseName;
	private String charSet;
	private Connection connection;

	public DefaultConnectionDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	
			this.databaseName = "pabebeinventorystore";
			this.charSet = "?useUnicode=true&amp;characterEncoding=utf-8";
			this.host = "jdbc:mysql://10.120.20.131:3306/" + this.databaseName + this.charSet;
			this.user = "root";
			this.password = "root";

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void setConnection(){
		try {
			this.connection = DriverManager.getConnection(this.host, this.user, this.password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
	
	public Connection getConnection(){
		return this.connection;	
	}
	
	public void closeConnection(){
		try {
			this.connection.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}		
	}
}
