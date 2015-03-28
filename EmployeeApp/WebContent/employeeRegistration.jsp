<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="javascript/validation.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	response.setHeader("cache-control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<title>Employee Registration</title>

<!-- The name is generally used as an attribute in all cases. -->
</head>
<body>
	<ul>
		<li><a
			href="<%=request.getContextPath()%>/EmployeeServlet?action=viewEmployee">View
				Employees</a></li>
		<li><a
			href="<%=request.getContextPath()%>/jsp/deleteEmp.jsp">Delete
				Employee</a></li>
		<li><a
			href="<%=request.getContextPath()%>/EmployeeServlet?action=generateHeapDump">Generate
				Heap Dump</a></li>
	</ul>
	<center>
		<font size="5px" color="#16719e">Employee Details</font>
	</center>

	<form name="fuser" id="fuser" action="<%=request.getContextPath()%>/EmployeeServlet" Method="Post">
		<center>
			<table align="center">

				<tr>
					<td>Name</td>
					<td><input type="text" name="empName"></td>
					<!--<td><input type="hidden" name="empName" value="temp"
						onBlur="return checkcou()"></td>-->

				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="empNum"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="text"></td>
					<td><input type="hidden" name="empRole"></td>
				</tr>
				<tr>
					<td>Team Member</td>
					<td><select name="empTeam">
							<option value="Performance Testing">Performance Testing</option>
							<option value="Automation Testing">Automation Testing</option>
							<option value="Security Testing">Security Testing</option>
					</select></td>

				</tr>
				<tr>
					<td><input type="hidden" name="action" value="createempID"></td>
				</tr>
			</table>


		</center>
		<center>
			<input type="submit" value="submit" id="sbmt"> <input
				type="reset" value="reset"
				onclick="return confirm('Please confirm if you want to reset ?')">
		</center>

	</form>
</body>
</html>