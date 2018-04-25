package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LocationReviews extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	String lat = request.getParameter("t1").trim();
	String lon = request.getParameter("t2").trim();
	String name = request.getParameter("t3").trim().toLowerCase();
	try{
		HttpSession session=request.getSession();
		session.setAttribute("pname",name);
		Classify.classify(lat,lon,name);
		RequestDispatcher rd=request.getRequestDispatcher("LocationClassify.jsp");
		rd.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
