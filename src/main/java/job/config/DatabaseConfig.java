package job.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
public static Connection getConnection()
{
	String dburl = "jdbc:mysql://localhost:3306/job";
	String username="root";
	String password="2000";
	Connection connect=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 connect=DriverManager.getConnection(dburl, username, password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return connect;
	
}
}




