<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
<ul>
		<li><a
			href="<%=request.getContextPath()%>/employeeRegistration.jsp">Register
				Employee</a></li>
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
<form name="fuser" id="fuser" action="<%=request.getContextPath()%>/EmployeeServlet" Method="Post">
<center>
			<table align="center">

				<tr>
					<td>Enter EmpID to be Deleted</td>
					<td><input type="text" name="empIDDel"></td>
					<td><input type="submit" value="Delete"></td>
					<td><input type="hidden" name="action" value="deleteEmpID"></td>
				
					
					</tr>
					</table>
					</center>
					</form>
</body>
</html>