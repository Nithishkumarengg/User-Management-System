package job.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import job.config.DatabaseConfig;
import job.entity.user;

public class Usersmodel {
public List<user> listuser(){

	List<user> listusers=new ArrayList<user>();
	
	Connection connect = DatabaseConfig.getConnection();
	String query="SELECT * FROM job.users";//create query
	
	Statement stmt = null;
	ResultSet rs = null;

	try {
	    if (connect != null) {
	        stmt = connect.createStatement();
	        rs = stmt.executeQuery(query);
	    	while(rs.next()) {
				listusers.add(new user(rs.getInt("user_id"),rs.getString("username"),rs.getString("email")));
			}
			
	        // Rest of your code
	    } //else {// Handle the case where the connection is null
	        //System.out.println("Connection is null. Unable to execute the query.");
	    //}
	} catch (SQLException e) {
	    e.printStackTrace(); // Handle the SQL exception
	} /*finally {
	    // Close resources in a finally block (if needed)
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (connect != null) {
	            connect.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/
	return listusers;

	
}



public void Adduser(user newUser) {
	Connection connect=null;
	PreparedStatement statement=null;
	
	connect=DatabaseConfig.getConnection();
	String username=newUser.getUsername();
	String email=newUser.getEmail();
	String query="insert into users (username,email) values(?,?)";
	try {
		statement=connect.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, email);
		statement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public void updateuser(user updateduser) {
	Connection connect=null;
	PreparedStatement statement=null;
	
	connect=DatabaseConfig.getConnection();
	int user_id=updateduser.getUser_id();
	String username=updateduser.getUsername();
	String email=updateduser.getEmail();
	String query="update users set username=? , email=? where user_id=? ";
	try {
		statement=connect.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, email);
		statement.setInt(3, user_id);
		statement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void deleteuser(int userid) {
	Connection connect=null;
	PreparedStatement statement=null;
	
	connect=DatabaseConfig.getConnection();
	
	String query="delete from users where user_id= ? ";
	try {
		statement=connect.prepareStatement(query);
		statement.setInt(1, userid);
		statement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
