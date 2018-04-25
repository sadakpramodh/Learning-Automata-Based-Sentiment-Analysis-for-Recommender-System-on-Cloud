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
<form name="f1" method="post" action="AllReviews" onsubmit="return validate(this);"><br/>
   <h2><b>All Reviews Screen</b></h2>
   <br/>
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=white>"+res+"</center></font>");
	}%>
						
						<table align="center" width="40" >
			 <tr><td><b>Choose&nbsp;Option</b></td><td>
			 <select name="t1">
			 <option value="MOVIES">MOVIES</option>
			 <option value="RESTAURANT">RESTAURANT</option>
			 </select>
			 </td></tr>
         
		 
			<tr><td></td><td><input type="submit" value="Get Result"></td>
			</table>
				</div>	
					
				</div>
				
</body>
</html>