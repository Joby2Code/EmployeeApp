package com.adobe.presentation.bean;

public class Employee {
	private String empName;
	private String empNumber;
	private String empRole;
	private String empTeam;
	private String empID;
	
	public Employee() {
	}

	public String getEmpID() {
		return empID;
	}

	/*public void setEmpID(String empID) {
		this.empID = empID;
	}*/

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmpTeam() {
		return empTeam;
	}

	public void setEmpTeam(String empTeam) {
		this.empTeam = empTeam;
	}

	public void setEmpID(String empID2) {
		// TODO Auto-generated method stub
		this.empID=empID2;
	}

}
