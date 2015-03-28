<%@page import="com.adobe.presentation.bean.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table, th, td {
    border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee</title>
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
	<center>
<font size="5px" color="#16719e">Employee Details</font>
<%
ArrayList<Employee> empLst = (ArrayList) request.getAttribute("list");

 %>
 
 <%
		    if(!(empLst.isEmpty())){
		    	%><table border="1">
	<tr><th bgcolor="#00FF00">S.No</th>
		<th bgcolor="#00FF00">Name</th>
		<th bgcolor="#00FF00">team</th>	</tr><% int j=0;int count=0;
			for(Employee emp:empLst)
			{
					
	%>
	
		

	<tr>
	<td><%=++j %></td><td><%=emp.getEmpName()%></td><td><%=emp.getEmpTeam()%></td>
			
	<%
		}
		    } else {%> <br></br> </table> 
		    
			<font color="red">No Employees found in the database</font>
			  
		    	
		    <% } %>
	</center>	 
</body>
</html>