package com.adobe.presenation.dao;

import java.sql.*;
import java.util.ArrayList;

import com.adobe.presentation.bean.Employee;
import com.adobe.presesntation.util.DBConnection;

public class EmployeeDao {
	private int noOfRecords;
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs=null;
	public EmployeeDao() {

	}

	public int addEmployee(Employee emp) throws ClassNotFoundException,
			SQLException {
		int rowsAffected = 0;
		try {

			connection = DBConnection.getConnection();
			String insertUserQuery = "INSERT INTO NewEmployee(Name,PhoneNumber,Role,Team,EmpID) values(?,?,?,?,?)";
			System.out.println("inside dao");

			preparedStatement = connection.prepareStatement(insertUserQuery);

			preparedStatement.setString(1, emp.getEmpName());
			preparedStatement.setString(2, emp.getEmpNumber());
			preparedStatement.setString(3, emp.getEmpRole());
			preparedStatement.setString(4, emp.getEmpTeam());
			preparedStatement.setString(5, emp.getEmpID());

			rowsAffected = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
					System.out.println("Connection is closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rowsAffected;

	}

	public ArrayList<Employee> viewAllemp() throws SQLException{
		// TODO Auto-generated method stub
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			connection = DBConnection.getConnection();

			// Using Prepared Statement
			String selectUserQuery = "select * from NewEmployee Order By Team";
			System.out.println("selectUserQuery : " +selectUserQuery );

			preparedStatement = connection.prepareStatement(selectUserQuery);
			//preparedStatement.setString(1, spid);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee obj = new Employee();

				obj.setEmpName(rs.getString(1));
				obj.setEmpTeam(rs.getString(4));

				empList.add(obj);
			}

			for (Employee test : empList) {
				System.out.println(test.getEmpName());

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	public int deleteEmploy(Employee emp) {
		// TODO Auto-generated method stub
		
		int rowsAffected = 0;
		try {

			connection = DBConnection.getConnection();
			String insertUserQuery = "delete from NewEmployee  WHERE EmpID=?";

			preparedStatement = connection.prepareStatement(insertUserQuery);

			preparedStatement.setString(1, emp.getEmpID());

			rowsAffected = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
					System.out.println("Connection is closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rowsAffected;
		
	}

	public String searchEmployee(String empID) {
		// TODO Auto-generated method stub
	String empName = null;
		try {
			connection = DBConnection.getConnection();

			// Using Prepared Statement
			String selectUserQuery = "select * from NewEmployee where EmpID=?";
			System.out.println("selectUserQuery : " +selectUserQuery );

			preparedStatement = connection.prepareStatement(selectUserQuery);
			preparedStatement.setString(1, empID);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee obj = new Employee();

				obj.setEmpName(rs.getString(1));
				empName=obj.getEmpName();
				//obj.setEmpTeam(rs.getString(4));

				
			}

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empName;
		
	}
	}

