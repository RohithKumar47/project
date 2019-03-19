package Legato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Consql {
	public static Connection getConnection() {
		try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Honeykiliki47&");
		return con;
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void validate(String username,String password,Connection con) {

	
	}
}
