<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="free design template, CSS template, HTML website" />
<meta name="description" content="Free Design Template, Free CSS Website, XHTML CSS layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function validate(formObj)
	{
	if(formObj.t1.value.length==0)
	{
	alert("Please Enter Product Name");
	formObj.t1.focus();
	return false;
	}
	if(formObj.t2.value.length==0)
	{
	alert("Please Enter Feedback");
	formObj.t2.focus();
	return false;
	}
	
	formObj.actionUpdateData.value="update";
	return true;
	}
	</script>
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
<form name="f1" method="post" action="Assign" onsubmit="return validate(this);"><br/>
   <h2><b>Feedback Screen</b></h2>
   <br/>
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=white>"+res+"</center></font>");
	}%>
						
						<table align="center" width="40" >
			 <tr><td><b>Product&nbsp;Name</b></td><td><input type="text" name="t1" style="font-family: Comic Sans MS" size="40"/></td></tr>

			  <tr><td><b>Feedback</b></td><td><textarea name="t2" rows="10" cols="40"></textarea></td></tr>

			   
         
		 
			<tr><td></td><td><input type="submit" value="Submit"></td>
			</table>
				</div>	
					
				</div>
				
</body>
</html>