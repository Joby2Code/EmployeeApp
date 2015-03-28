package com.adobe.presentation.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;

import com.adobe.presenation.dao.EmployeeDao;
import com.adobe.presentation.bean.Employee;
import com.adobe.presnetation.MutilThreads.CountDownClock;
import com.adobe.presnetation.MutilThreads.NewThread;

public class EmployeeManager {
	private static int counter = 0;
	EmployeeDao dobj = new EmployeeDao();

	public EmployeeManager() {
	}

	public String generateEmpID(Employee emp) {
		// TODO Auto-generated method stub
		String temp, empID, empIDM = null;
		;
		String name = emp.getEmpName();
		String seedStr2 = name.substring(0, 2);
		System.out.println(seedStr2);
		String seedStr = seedStr2 + "_";
		System.out.println(seedStr);
		Random randomid = new Random();
		int EmpIDInt = randomid.nextInt(1000);
		temp = Integer.toString(EmpIDInt);
		empID = seedStr.concat(temp);
		System.out.println(empID);
		emp.setEmpID(empID);
		// String empIDM = null;
		System.out.println("Employee id is " + name + "EmpID is"
				+ emp.getEmpID());
		try {
			empIDM = createEmpDaoID(emp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empIDM;
	}

	public String createEmpDaoID(Employee emp) throws ClassNotFoundException,
			SQLException {
		Thread.currentThread().setName("Main User thread");
		System.out.println("The employee reg thread is"
				+ Thread.currentThread().getName());
		counter = 1;
		CountDownClock obj2 = new CountDownClock();
		obj2.setName("ClockThread_" + counter);
		obj2.start();

		NewThread obj3 = new NewThread();
		// TODO Auto-generated method stub

		counter = counter + 1;
		if (dobj.addEmployee(emp) >= 1) {
			return "Please note your empID " + emp.getEmpID();
		} else
			return "Please try again ";

	}

	public ArrayList<Employee> viewAllEmployee() throws SQLException {
		// TODO Auto-generated method stub

		ArrayList<Employee> list = new ArrayList<Employee>();

		try {
			list = dobj.viewAllemp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public String deleteEmployee(Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		String name = dobj.searchEmployee(emp.getEmpID());

		if (dobj.deleteEmploy(emp) >= 1) {
			return name + " deleted successfully";
		} else {
			return "Employee not found. Please try again";
		}

	}

	public void generateDump() throws OutOfMemoryError, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inside dump");
		ArrayList<String> a = new ArrayList<String>();
		while (true) {
			a.add("asdfasdjf;lasdkjfl;SJF;LAJFDL;ASJDFL;ASJDFL;AJSDFL;JSLFJSDL;FJS;LFJA;LSDKJ;ksdjflsjdf;lasjdlfkj");
		}
	}

}
