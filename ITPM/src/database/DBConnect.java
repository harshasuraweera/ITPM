package database;


import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.xdevapi.Statement;



public class DBConnect {

   
  static Connection conn = null;
  @SuppressWarnings("rawtypes")
  Statement stmt = null;
  static String url = "jdbc:mysql://151.106.114.2:3306/u271442347_itpm_db";
  static String userName = "u271442347_itpm_user";
  static String password = "80tlxBtuX";
  


  public static Connection getConnection() {
      
      try {
        
        Class.forName("com.mysql.cj.jdbc.Driver"); 
          conn = DriverManager.getConnection(url,userName, password);
          //System.out.println("Database connection is success!!!");
        
      }
      catch (Exception e) {
        //System.out.println("Database connection is not success!!!");
      }
      
      
      
      return conn;
  }
  
  
}