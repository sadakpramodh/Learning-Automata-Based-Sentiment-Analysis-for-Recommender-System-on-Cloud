package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AllReviews extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	String option = request.getParameter("t1").trim();
	try{
		HttpSession session=request.getSession();
		Classify.classify(option);
		session.setAttribute("option",option);
		RequestDispatcher rd=request.getRequestDispatcher("Classify.jsp");
		rd.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
