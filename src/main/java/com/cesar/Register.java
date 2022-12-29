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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
        //Fetchong from HTML form
        String a1=request.getParameter("cardno");
        String a2=request.getParameter("edate");
        String a3=request.getParameter("cvv");
        String a4=request.getParameter("cname");
        String a5=request.getParameter("enum");
        String a6=request.getParameter("ename");
        //Connect to the Database
        try {
			//
        	Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/testingall";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(conURL, user, pass);
            Statement stmt=con.createStatement();
            //
            String Qs="insert into card values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"') ";
            stmt.executeUpdate(Qs);
            System.out.println("Agregado con exito...");
            //ResultSet rs=stmt.executeQuery(Qs);
            con.setAutoCommit(false);
            //con.commit();
            con.close();
            RequestDispatcher rd=request.getRequestDispatcher("Payment.html");
            rd.forward(request,response);  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

}
