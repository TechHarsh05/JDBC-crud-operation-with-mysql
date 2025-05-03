package jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class GetAllStudentController {

	
	public static void main(String[] args) {
		
//	1. Create Connection
		Connection connection = null;
		try {
			
//			2. Register Driver
			Driver driver = new Driver();
			
			Properties prop = new Properties();

			prop.put("user", "root");
			prop.put("password", "root");
			
			connection = driver.connect("jdbc:mysql://localhost:3306/jdbc-e4", prop);
			System.out.println("Connection is Created");
			
			String sql = "Select * From student;";

//			3. Create Statement
			Statement statement = connection.createStatement();
			
//			4. Execute Statement
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				String email = result.getString(3);
				Date date = result.getDate(4);
				System.out.println("id :"+id +" username :"+ name +" email :"+email+" dob :"+date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//				5. Close Connection
		finally {
			try {
				connection.close();
				System.out.println("Connection is closed");
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
}
