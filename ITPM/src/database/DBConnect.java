package database;


import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.xdevapi.Statement;



public class DBConnect {
	 
	static Connection conn = null;
	@SuppressWarnings("rawtypes")
	Statement stmt = null;
	static String url = "jdbc:mysql://sql122.main-hosting.eu:3306/u570148956_itpm";
	static String userName = "u570148956_itpm";
	static String password = "5^L8GQGZq";
		

	public static Connection getConnection() {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver"); 
	    		conn = DriverManager.getConnection(url,userName, password);
	    	//	System.out.println("Database connection is success!!!");
				
			}
			catch (Exception e) {
			//	System.out.println("Database connection is not success!!!");
			}
			
			return conn;
	}
	
	
}
