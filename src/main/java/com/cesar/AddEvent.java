package com.cesar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEvent() {
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
        //Fetching data from HTML form
        String a1=request.getParameter("EventNo");
        String a2=request.getParameter("EventName");
        String a3=request.getParameter("coordinatorName");
        String a4=request.getParameter("CoordinatorNo");
        String a5 =request.getParameter("fee");
        String a6=request.getParameter("venue");
        String a7=request.getParameter("date");
        //Connecting to the Database.
        try {
			//
        	Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/testingall";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(conURL, user, pass);//Establish Connection
            //
            Statement stmt=con.createStatement();
            String Qs="insert into Event values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"') ";
            stmt.executeUpdate(Qs);
            System.out.println("Datos agregados correctamente...");
            //ResultSet rs=stmt.executeQuery(Qs);
            //
            RequestDispatcher rd=request.getRequestDispatcher("CreateE.html");
            rd.include(request, response);
                 
            out.println("<br><center><h3> Event Added</h3></center>");
            System.out.println("Added to database!");
            con.commit();
            con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

}
