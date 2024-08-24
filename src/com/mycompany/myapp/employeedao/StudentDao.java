package com.mycompany.myapp.employeedao;

import com.mycompany.myapp.dbconnection.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mycompany.myapp.employee.Student;

public class StudentDao {

	public static void createStudent(Student student) {
		String query = "INSERT INTO student VALUES (?, ?, ?, ?)";

		try (Connection connection = dbconnection.connect();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, student.getRollno());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getEmail());
			int r = preparedStatement.executeUpdate();
			if (r > 0 ) {
				System.out.println("Student registration is successfull");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showAllStudent() {
		String query = "SELECT * FROM student";

		try (Connection connection = dbconnection.connect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteRecord(int rollno) {
		try {
			Connection connection = dbconnection.connect();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE rollno = ?");
			preparedStatement.setInt(1, rollno);

			int r = preparedStatement.executeUpdate();

			if (r > 0) {
				System.out.println("deleted successfully");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public static void updateEmail(int rollno, String newEmail) {
		try {
			Connection connection = dbconnection.connect();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET gmail = ? WHERE rollno = ?");
			preparedStatement.setString(1, newEmail);
			preparedStatement.setInt(2, rollno);
			

			int r = preparedStatement.executeUpdate();

			if (r > 0) {
				System.out.println("Email updated  successfully");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
