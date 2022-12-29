package com.cesar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateAd
 */
@WebServlet("/ValidateAd")
public class ValidateAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateAd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		PrintWriter out = response.getWriter();
        String un = request.getParameter("Ausername"); // Fetch username
        String pw = request.getParameter("Apassword"); // Fetch password
        response.setContentType("text/html");
     // Sets of Admin usernames & passwords
        String u1 ="cesar";
        String p1 ="123";
        
        String u2 ="giron111";
        String p2 ="123";
        
        String u3 ="A103";
        String p3 ="ABCD";
        
        String u4 ="A104";
        String p4 ="abcd";
        //
//if-else ladder to check entries 
        
        if(pw.equals(p1)&&un.equals(u1)){
            RequestDispatcher rd =request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        }
          else if(pw.equals(p2)&&un.equals(u2)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        else if(pw.equals(p3)&&un.equals(u3)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        else if(pw.equals(p4)&&un.equals(u4)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        // Credentials incorrect stay on that page only
        else
        {
        	out.println("<center><h1>!! Please Enter Valid Username & Password for Admin !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Alogin.html");
            rd.include(request, response);
        }//Else
        out.close();
	}

}
