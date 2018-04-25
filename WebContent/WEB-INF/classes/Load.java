package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Load extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	try{
		DBCon.fillWords();
		DBCon.readDBReview();
		System.out.println(DBCon.positive.size()+" "+DBCon.negative.size()+" "+DBCon.movie.size()+" "+DBCon.movie_review.size()+" "+DBCon.restaurant.size()+" "+DBCon.restaurant_review.size());
		RequestDispatcher rd=request.getRequestDispatcher("UserScreen.jsp?t1=Reviews From Database Loaded");
		rd.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
