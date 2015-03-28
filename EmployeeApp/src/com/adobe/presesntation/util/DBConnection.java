package com.adobe.presesntation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class DBConnection {
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/employee";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		System.out.println("Inside getConnection() method");

		Connection connection = null;
		try {
			Class.forName(DRIVERNAME);
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Got connection to MYSQL");

		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
