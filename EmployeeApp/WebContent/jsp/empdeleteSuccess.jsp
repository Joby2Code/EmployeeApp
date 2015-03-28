<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%String empStatus=(String)request.getAttribute("empName");

%>
	<ul>
		<li><a
			href="<%=request.getContextPath()%>/EmployeeServlet?action=viewEmployee">View
				Employees</a></li>
		<li><a
			href="<%=request.getContextPath()%>/jsp/deleteEmp">Delete
				Employee</a></li>
		<li><a
			href="<%=request.getContextPath()%>/EmployeeServlet?action=generateHeapDump">Generate
				Heap Dump</a></li>
	</ul>
	<center>
<font size="5px" color="#16719e"><%= empStatus %></font>
	</center>

</body>
</html>