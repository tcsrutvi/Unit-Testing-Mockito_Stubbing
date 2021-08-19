package com.in28minutes.unittesting.fitness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FitnessTrackerJdbc {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/fitness_tracker";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			create(statement);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	private static void create(Statement statement) throws SQLException {
		int weeks = 2;
		int price = 400;
		int amount = weeks*price;
		statement.execute("insert into appointments values(1,1,1,TRUE,1," + weeks + "," + amount + ")");
		
	}

}

