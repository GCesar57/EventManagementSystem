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
 * Servlet implementation class VaPa
 */
@WebServlet("/VaPa")
public class VaPa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaPa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    //
	    //Fetching data  from HTML form
	    String n=request.getParameter("Pausername");  
	    String p=request.getParameter("Papassword");  
	    //
	    if(LoginDao.validate(n, p)) {
	    	RequestDispatcher rd=request.getRequestDispatcher("ParticipantEvent.html");  
	        rd.forward(request,response);  
	    }else {
	    	out.print("<center><h1>Sorry username and password incorrect</h1></center>");  
	        RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");  
	        rd.include(request,response); 
	    }//
	    out.close();
	}
}
