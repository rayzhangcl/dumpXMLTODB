package ca.ualberta.cs.chenlei;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

 
public class connectDB {
	
  private static final String DBURL = "jdbc:mysql://localhost:3306/employee";
  private static final String DBUSER = "raydb";
  private static final String DBPW = "ray";
  
  
 
  public Connection conDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}

		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(DBURL,DBUSER, DBPW);

//			Statement st = connection.createStatement();
//			st.executeUpdate("CREATE DATABASE stackoverflow");
//			st.close();
	// 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} 
		return connection;
	  
  }
}