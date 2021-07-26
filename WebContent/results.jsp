<%--@author: Varun Kashyap--%>
<%--Description: User submission results page--%>

<!DOCTYPE html>

<%@page import="projectJavaClasses.Bean"%>
<%@ page import="java.util.Iterator" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>JHU- Seminar</title>
    <style>
    	<%@ include file="styles/main.css"%>
    </style>
</head>
<body>
	<img alt="Johns Hopkins Logo" src="images/jhu.jpeg">
	<h3>JOHNS HOPKINS ANNUAL SOFTWARE DEVELOPMENT SEMINAR</h3>
	<br>
	<% Bean javaBean = (Bean)session.getAttribute("bean");%>
	<% if(javaBean.getResultCheck()==1) {%>
	<span class="bold"><%=javaBean.getName() %></span>
	<p>You are registered as a <span class="bold"><%=javaBean.getEmployeeStatus() %></span></p>
	<p>Your e-mail confirmation will be sent to: <span class="bold"><%=javaBean.getEmail()%></span></p>
	<table class="table">
		 <tr>
		   <th>Your Courses</th>
		   <th>Cost</th>
		   <th></th>
		 </tr>
		 <%Iterator<String> itr = javaBean.getCoursesList().iterator(); %>
		 <%while (itr.hasNext()) { %>
		 <tr>
		 	<%String course = itr.next(); %>
		   		<td><%=course %></td>
		   		<td>$<%=javaBean.getCourseCost()%></td>
		   		<td>
     				<form action="" method="post">
        				<input type="hidden" name="courseCode" 
              				 value="<%=course %>">
        				<input type="hidden" name="course" 
             				  value="0">
        				<input type="submit" name="form" value="Remove">
      				</form>
    			</td>
		 	</tr>
		 
		 <%} %>
		 	
		 
		 <%if(javaBean.getHotelFeeSelected() == 1) { %>
		 	<tr>
		 		<td>Hotel Accomodation</td>
		 		<td>$<%=javaBean.getHotelFee() %></td>
		 		<td></td>
		 	</tr>
		 	<%} %>
		 	<%if(javaBean.getParkingFeeSelected() == 1) { %>
		 	<tr>
		 		<td>Parking Fee</td>
		 		<td>$<%=javaBean.getParkingFee() %></td>
		 		<td></td>
		 	</tr>
		 	<%} %>
		 	<tr>
		 		<td><h5>Total</h5></td>
		 		<td><h5>$<%=javaBean.getTotalCost() %></h5></td>
		 		<td></td>
		 	</tr>
	</table>
	<%} else { %>
		<h5>error: <%=javaBean.getErrorMessage() %></h5>
	<%} %>
	<br>
	<form action="mvc_servlet">
		<input type="submit" value="Edit Information" name="form">
		<input type="submit" value="Confirm Registration (In progress)" name="form">
	</form>
</body>
</html>