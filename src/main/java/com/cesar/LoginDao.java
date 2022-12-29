package com.cesar;
import java.sql.*;
public class LoginDao {
	//
	public static boolean validate(String User_name,String Pass_word) {
		//
		boolean status=false;  
		try {
			Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testingall","root","");
		    PreparedStatement ps=con.prepareStatement("select * from plogindeatils where user_name=? and pass_word=?");
		    ps.setString(1,User_name);  
		    ps.setString(2,Pass_word);  
		    ResultSet rs=ps.executeQuery();  
		    status=rs.next();
		    con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return status; 
	}//

}
