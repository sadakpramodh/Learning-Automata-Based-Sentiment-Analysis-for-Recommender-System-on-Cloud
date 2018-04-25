<%@page import="java.util.ArrayList"%>
<%@page import="com.Movies"%>
<%@page import="com.MovieReviews"%>
<%@page import="com.Restaurants"%>
<%@page import="com.RestaurantReviews"%>
<%@page import="com.DBCon"%>
<%@page import="com.Classify"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="free design template, CSS template, HTML website" />
<meta name="description" content="Free Design Template, Free CSS Website, XHTML CSS layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Download Free CSS Templates from www.templatemo.com  -->	
<div id="templatemo_header_panel">
	<div id="templatemo_header_section">
    	
        <div id="tagline"></div>
    </div>
</div> <!-- end of haeder -->

<div id="templatemo_menu_panel">
    <div id="templatemo_menu_section">
        <ul>
            <li><a href="Load"  >Load&nbsp;Reviews</a></li>
			<li><a href="AllReviews.jsp">All&nbsp;Reviews</a></li>
			<li><a href="LocationReviews.jsp">Location&nbsp;Based&nbsp;Reviews</a></li>
			<li><a href="Assign.jsp">Assign&nbsp;Feedback</a></li>
			<li><a href="Logout.jsp">Logout</a></li>
                             
        </ul> 
</div> <!-- end of menu -->
<br/>
	<center>
  
  
						
						<table align="center" border="1" width="100%" >
			  <tr><th>ID</th><th>Product ID</th><th>Product Name</th>
			  <th>Summary</th><th>Result</th><th>Restaurant Name</th><th>Address</th><th>Distance</th>
			 <%
			 String pname = (String)session.getAttribute("pname");
			 ArrayList<RestaurantReviews> restaurant_review = DBCon.getRestaurantReview();
			 for(int i=0;i<restaurant_review.size();i++){
				 RestaurantReviews mr = restaurant_review.get(i);
				 if(mr.getResult() != null){
					 if(mr.getName().toLowerCase().equals(pname)){
						 String str = Classify.getName(mr.getID());
						 String arr[] = str.split(",");
				 %>
				 <tr><td><%=mr.getID()%></td>
				 <td><%=mr.getProduct()%></td>
				 <td><%=mr.getName()%></td>
				 <td><%=mr.getSummary()%></td>
				 <td><%=mr.getResult()%></td>
				 <td><%=arr[0]%></td>
				 <td><%=arr[1]%></td>
				  <td><%=mr.getDistance()%></td>
				</tr>
				 <%}}}%>

			</table>
				</div>	
					
	
				</div>
				
</body>
</html>