package com.adobe.presentation.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adobe.presentation.bean.Employee;
import com.adobe.presentation.service.EmployeeManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		Employee emp = new Employee();
		EmployeeManager obj = new EmployeeManager();
		if (action.equalsIgnoreCase("createempID")) {
			String empName = request.getParameter("empName");
			String empNum = request.getParameter("empNum");
			String empRole = request.getParameter("empRole");
			String empTeam = request.getParameter("empTeam");
			System.out.println("Inside servlet" + empName + " " + empTeam);
			try {
				
				emp.setEmpName(empName);
				emp.setEmpNumber(empNum);
				emp.setEmpRole(empRole);
				emp.setEmpTeam(empTeam);
				String empID = obj.generateEmpID(emp);

				System.out.println(empID);
				request.setAttribute("empid", empID);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/empid.jsp");
				rd.include(request, response);
			} 
			 catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.equalsIgnoreCase("viewEmployee"))
		{
			try
			{
			ArrayList<Employee> list = obj.viewAllEmployee();
			

			System.out.println("Inside Servelt twoway");
			
			request.setAttribute("list", list);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ViewAllEmployee.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			catch(SQLException e)
			{
		    request.setAttribute("Exception", e.getMessage());
		    RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/ExceptionHandler.jsp");
			rd.forward(request, response);
		}
		}
		
		if(action.equalsIgnoreCase("deleteEmpID"))
		{
			String empID=request.getParameter("empIDDel");
			emp.setEmpID(empID);
			try {
				String empName=obj.deleteEmployee(emp);
				request.setAttribute("empName", empName);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/empdeleteSuccess.jsp");
				rd.include(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(action.equalsIgnoreCase("generateHeapDump"))
		{
			System.out.println("In  heap code");
			try
			{
			obj.generateDump();
			}
			catch(ServletException e)
			{
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/OutofMem.jsp");
				rd.include(request, response);
			}
			catch(OutOfMemoryError e)
			{
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/OutofMem.jsp");
				rd.include(request, response);
			}
		}
	}
}
