package com.cesar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ViewEvent1
 */
@WebServlet("/ViewEvent1")
public class ViewEvent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEvent1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event  Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        //
        try {
			//
        	Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/testingall";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(conURL, user, pass);
            //
            response.setContentType("text/html");
            Statement stmt1 = con.createStatement();  
            ResultSet rp = stmt1.executeQuery("select * from Event"); 
            //
            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");
            //
            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>EventNumber</th><th>EventName</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>"); 
            //
            while(rp.next()) {
            	String n = rp.getString("enum");  
                String nm = rp.getString("ename");  
                String co = rp.getString("coord");
                String cono  = rp.getString("coordnum");
                String f=rp.getString("fee");
                String v=rp.getString("venue");
                String d=rp.getString("edate");
                out.println("<tr><td>" + n + "</td><td>" + nm +"</td><td>"+co+"</td><td>"+cono+"</td><td>"+f+"</td><td>"+v+"</td><td>"+d+"</td></tr>");
            }//While loop
            con.commit();
            con.close(); 
            out.println("</table>"); 
            out.println("</center>");
            out.print("</body>");
            out.print("</html>");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

}
