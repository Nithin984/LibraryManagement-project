package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcUtil {


	public static Connection jdbcconnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loading");
	//make the connection to the sql database(jdbc)
	FileInputStream f=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\LibraryManagement\\src\\jdbc.properties");
	Properties p=new Properties();
	p.load(f);
	
			
		
		  Connection connection=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password")); 
		  return connection;
	
	}

}
