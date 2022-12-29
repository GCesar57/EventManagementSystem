package com.cesar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class StoreP
 */
@WebServlet("/StoreP")
public class StoreP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        //Fetching data from Psignup.html from user
		String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");
        String name = request.getParameter("Pname");
        
        // Asign to another strings 
        String a1=up;
        String a2=pp;
        String a3=cp;
        String a4 =name;
        //
        if(a2.equals(a3)) {
        	//Connection & storing into Database
        	try {
				//
        		Class.forName("com.mysql.jdbc.Driver");
        		String conURL = "jdbc:mysql://localhost:3306/testingall";
                String user = "root"; // Username of  database
                String pass = ""; //Password for system
                // Create connection
                Connection con = DriverManager.getConnection(conURL, user, pass);
                Statement stmt=con.createStatement();
                String Qs="insert into plogindeatils(user_name, pass_word, name) values('"+a1+"','"+a2+"','"+a4+"') ";
                stmt.executeUpdate(Qs);
                //ResultSet rs=stmt.executeQuery(Qs);
                //
                RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");
                rd.forward(request, response);
                con.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
        }else {
        	//
        	out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }//
	}

}
