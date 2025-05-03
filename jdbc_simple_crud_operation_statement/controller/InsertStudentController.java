package jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {
	public static void main(String[] args) {
		Connection connection = null;
			
		try {			
			// Step-1 Load or Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step-2 create Connection
			
			String url = "jdbc:mysql://localhost:3306/jdbc-e4";
			String username = "root";
			String password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
						
//			Step-3 create statement
			
			Statement statement = connection.createStatement();
			
			
//			Step-4 Execute Query
						
			String sql = "insert into student(id, name, email, dob) values(104, 'sumit', 'sumit@gmail.com', '1999-05-16')";
			
			//	It gives integer value if success = 1 else 0
			int result= statement.executeUpdate(sql);
			System.out.println(result);
			
			
			if(result != 0) {
				System.out.println("Data Inserted");
			}else {
				System.out.println("Data Could not inserted");
			}
						
			
		} catch (java.lang.ClassNotFoundException | java.sql.SQLException e ) {
			e.printStackTrace();
		}finally {
			
//			Step-5 Create Connection close
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
