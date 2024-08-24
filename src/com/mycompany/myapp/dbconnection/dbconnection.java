package com.mycompany.myapp.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	static Connection conn = null;

	public static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/rohit";
			String username = "root";
			String password = "Rohit@12345";

			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
