<%--@author: Varun Kashyap--%>
<%--Description: Previous selection edit page--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="projectJavaClasses.Bean"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JHU- Seminar</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<%Bean javaBean = (Bean)session.getAttribute("bean"); %>
<%String name = javaBean.getName(); %>
<%String email = javaBean.getEmail(); %>
<%List<String> courses = javaBean.getCoursesList(); %>
<%String employeeStatus = javaBean.getEmployeeStatus(); %>
<%Integer hotelFeeSelected = javaBean.getHotelFeeSelected(); %>
<%Integer parkingFeeSelected = javaBean.getParkingFeeSelected(); %>
<%String checkedEmployee = ""; %>
<%String checkedStudent = ""; %>
<%String checkedSpeaker = ""; %>
<%String checkedOther = ""; %>
<%String checkedHotelFee = ""; %>
<%String checkedParkingFee = ""; %>
<% if(employeeStatus.equals("JHUEmployee")) {%>
	<%checkedEmployee = "checked";%>
<%} else if(employeeStatus.equals("JHU Student")) {%>
	<%checkedStudent = "checked";%>
<%} else if(employeeStatus.equals("Speaker")) {%>
	<%checkedSpeaker = "checked";%>
<%} else {%>
	<%checkedOther = "checked";%>
<%}%>

<% if(hotelFeeSelected == 1) {%>
	<% checkedHotelFee = "checked";%>
<%} %>

<% if(parkingFeeSelected == 1) {%>
	<% checkedParkingFee = "checked";%>
<%} %>

<%String nextCourse = "";%>
<%String checkedWeb = "";%>
<%String checkedJ2EE = "";%>
<%String checkedService = "";%>
<%String checkedEnterprise = "";%>
<%String checkedSecure = "";%>
<%String checkedWeb1 = "";%>
<%Iterator<String> itr = courses.iterator();%>
			<%while(itr.hasNext()) {%>
				<%nextCourse = itr.next();%>
				<%if (nextCourse.equals("A4- Web Services")) {%>
					<%checkedWeb = "selected";%>
				<%} else if (nextCourse.equals("A1- J2EE Design Patterns")) {%>
					<%checkedJ2EE = "selected";%>
				<%} else if (nextCourse.equals("A3- Service Oriented Architectures")) {%>
					<%checkedService = "selected";%>
				<%} else if (nextCourse.equals("A4- Enterprise Service Bus")) {%>
					<%checkedEnterprise = "selected";%>
				<%} else if (nextCourse.equals("A6- Secure Messaging")) {%>
					<%checkedSecure = "selected";%>
				<%} else {%>
					<%checkedWeb1 = "selected";%>
				<%}%>
			<%}%>


<img alt="Johns Hopkins Logo" src="images/jhu.jpeg">
	<h3>JOHNS HOPKINS ANNUAL SOFTWARE DEVELOPMENT SEMINAR</h3>
	<br>
	<form action="mvc_servlet" method="post">
 		<fieldset class="fieldset">
			 <legend class="legend">Contact Information</legend>
			 <label class="ptext">Name:</label>
			 <input type="text" name="name" value="<%=name %>" required>
			 <br>
			 <label class="ptext">Email:</label>
			 <input type="email" name="email" value="<%=email %>" required>
		</fieldset>
		<br>
		<fieldset class="fieldset">
			 <legend class="legend">Select Your Courses</legend>
			 	<select name="courses" multiple size="6" required>
  					<option value="A4- Web Services" <%=checkedWeb %>>A4- Web Services</option>
					<option value="A1- J2EE Design Patterns" <%=checkedJ2EE %>>A1- J2EE Design Patterns</option>
					<option value="A3- Service Oriented Architectures" <%=checkedService %>>A3- Service Oriented Architectures</option>
					<option value="A4- Enterprise Service Bus" <%=checkedEnterprise %>>A4- Enterprise Service Bus</option>
					<option value="A6- Secure Messaging" <%=checkedSecure %>>A6- Secure Messaging</option>
					<option value="A5- Web Services Security" <%=checkedWeb1 %>>A5- Web Services Security</option>
				</select>
		</fieldset>
		<br>
		<fieldset class="fieldset">
			 <legend class="legend">Employee Status</legend>
			
			 <input type="radio" name="status" value="JHUEmployee" <%=checkedEmployee %> required>
			 <label for="JHUEmployee" class="ptext">JHU Employee</label>
			 <input type="radio" name="status" value="JHUStudent" <%=checkedStudent %>>
			 <label for="JHUStudent" class="ptext">JHU Student</label>
			 <input type="radio" name="status" value="Speaker" <%=checkedSpeaker %>>
			 <label for="Speaker" class="ptext">Speaker</label>
			 <input type="radio" name="status" value="Other" <%=checkedOther %>>
			 <label for="Other" class="ptext">Other</label>
			 
		</fieldset>
		<br>
		<fieldset class="fieldset">
			 <legend class="legend">Additional Fees and Charges</legend>
			 <input type="checkbox" name="hotelFee" value="hotelFee" <%=checkedHotelFee %>>
			 <label for="hotelFee" class="ptext">Hotel Accommodation (Conferences Guest Special Fee- Parking Included)</label>
			 <br>
			 <input type="checkbox" name="parkingFee" value="parkingFee"<%=checkedParkingFee %>>
			 <label for="parkingFee" class="ptext">Parking Permit</label>
		</fieldset>
		<br>
		<input type="submit" value="Compute Seminar Costs" name="form">
</form>
</body>
</html>