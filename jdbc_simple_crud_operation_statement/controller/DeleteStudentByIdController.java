package jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteStudentByIdController {
	public static void main(String[] args) {

//		1. Create Connection
		Connection connection = null;
		try {

			Driver driver = new Driver();
						
//			2. Register Driver
			 DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-e4";
			String username = "root";
			String password = "root";

			connection = DriverManager.getConnection(url, username, password);

//			3. create Statement
			Statement statement = connection.createStatement();

			String sql = "Delete from student where id = 104";

//			4. Execute Statement
			int b = statement.executeUpdate(sql);
			System.out.println(b);

		} catch (SQLException e) {
			e.printStackTrace();
		}

//			5. Close Connection
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
