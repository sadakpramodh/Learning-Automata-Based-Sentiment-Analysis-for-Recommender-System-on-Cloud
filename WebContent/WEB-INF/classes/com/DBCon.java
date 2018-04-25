package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class DBCon{
    private static Connection con;
	static ArrayList<String> positive = new ArrayList<String>();
	static ArrayList<String> negative = new ArrayList<String>();
	static ArrayList<Movies> movie = new ArrayList<Movies>();
	static ArrayList<MovieReviews> movie_review = new ArrayList<MovieReviews>();
	static ArrayList<Restaurants> restaurant = new ArrayList<Restaurants>();
	static ArrayList<RestaurantReviews> restaurant_review = new ArrayList<RestaurantReviews>();
public static ArrayList<MovieReviews> getMovieReview(){
	return movie_review;
}
public static ArrayList<RestaurantReviews> getRestaurantReview(){
	return restaurant_review;
}
public static void fillWords() throws Exception {
	if(positive.size() == 0){
		con = getCon();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from negative_word");
		while(rs.next()){
			negative.add(rs.getString(1).trim());
		}
		rs.close();stmt.close();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from positive_word");
		while(rs.next()){
			positive.add(rs.getString(1).trim());
		}
		rs.close();stmt.close();con.close();
	}
}
public static void readDBReview()throws Exception {
	if(movie.size() == 0){
		con = getCon();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from movies");
		while(rs.next()){
			Movies mov = new Movies();
			mov.setID(rs.getString(1));
			mov.setName(rs.getString(2));
			mov.setAddress(rs.getString(3));
			mov.setLon(rs.getDouble(4));
			mov.setLat(rs.getDouble(5));
			movie.add(mov);
		}
		rs.close();stmt.close();

		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from restaurants");
		while(rs.next()){
			Restaurants res = new Restaurants();
			res.setID(rs.getString(1));
			res.setName(rs.getString(2));
			res.setAddress(rs.getString(3));
			res.setLon(rs.getDouble(4));
			res.setLat(rs.getDouble(5));
			restaurant.add(res);
		}
		rs.close();stmt.close();

		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from movies_reviews");
		while(rs.next()){
			MovieReviews movr = new MovieReviews();
			movr.setID(rs.getString(2));
			movr.setProduct(rs.getString(3));
			movr.setName(rs.getString(4));
			String summary = rs.getString(5).toLowerCase().trim();
			summary = summary.replaceAll("[^a-zA-Z\\s+]", "");
			movr.setSummary(summary.trim());
			movr.setText(new String(rs.getBytes(6)));
			movie_review.add(movr);
		}
		rs.close();stmt.close();

		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from restaurants_reviews");
		while(rs.next()){
			RestaurantReviews resr = new RestaurantReviews();
			resr.setID(rs.getString(2));
			resr.setProduct(rs.getString(3));
			resr.setName(rs.getString(4));
			String summary = rs.getString(5).toLowerCase().trim();
			summary = summary.replaceAll("[^a-zA-Z\\s+]", "");
			resr.setSummary(summary.trim());
			resr.setText(new String(rs.getBytes(6)));
			restaurant_review.add(resr);
		}
		rs.close();stmt.close();con.close();
	}
}
public static Connection getCon()throws Exception {
   try{
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://52.237.36.87/sentiment_analysis","sadakpramodh","Parkshinhye@7");
     
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
}
public static String saveFeedback(String user,String pname,String feedback)throws Exception{
	String msg = "error";
	con = getCon();
	PreparedStatement stat=con.prepareStatement("insert into feedback values(?,?,?)");
	stat.setString(1,user);
	stat.setString(2,pname);
	stat.setString(3,feedback);
	int i=stat.executeUpdate();
	if(i > 0){
		msg = "success";
	}
    return msg;
}
public static String register(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    boolean flag1=false;
    con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from newuser where username='"+input[0]+"'");
    if(rs.next()){
        flag=true;
        msg = "Username already exist";
    }
    stmt=con.createStatement();
    rs=stmt.executeQuery("select password from newuser where password='"+input[1]+"'");
    if(rs.next()){
        flag1=true;
        msg = "Password already exist";
    }
	if(!flag && !flag1){
		PreparedStatement stat=con.prepareStatement("insert into newuser values(?,?,?,?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		stat.setString(3,input[2]);
		stat.setString(4,input[3]);
		stat.setString(5,input[4]);
		int i=stat.executeUpdate();
		if(i > 0){
			msg = "success";
		}
    }
    return msg;
}

public static String login(String input[])throws Exception{
    String msg="invalid login";
	con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from newuser where username='"+input[0]+"' and password='"+input[1]+"'");
    if(rs.next()){
	    msg = "valid";
    }
    return msg;
}

}
