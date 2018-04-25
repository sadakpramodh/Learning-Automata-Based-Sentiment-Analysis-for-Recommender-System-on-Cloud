package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Assign extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession session=request.getSession();
	PrintWriter out = response.getWriter();
	String pname=request.getParameter("t1");
	String feedback=request.getParameter("t2");
	String user = (String)session.getAttribute("user");
	try{
		String msg = DBCon.saveFeedback(user,pname,feedback);
		if(msg.equals("success")){
			RequestDispatcher rd=request.getRequestDispatcher("UserScreen.jsp?t1=Feedback details added");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("UserScreen.jsp?t1=Error in adding feedback");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
